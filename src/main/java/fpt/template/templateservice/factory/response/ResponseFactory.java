package fpt.template.templateservice.factory.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import fpt.template.templateservice.config.MessageResponseConfig;
import fpt.template.templateservice.constant.Constants;
import fpt.template.templateservice.constant.ResponseStatusCode;
import fpt.template.templateservice.dto.BaseResponse;
import fpt.template.templateservice.dto.ResponseStatus;
import fpt.template.templateservice.service.constant.ErrorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;


@Component("chatbotResponseFactory")
@Slf4j
public class ResponseFactory {

    @Autowired(required = false)
    private ErrorService errorService;

    @Autowired
    private MessageResponseConfig messageResponseConfig;

    /**
     * Replace params in message
     *
     * @param message
     * @param params
     * @return
     */
    private String replaceParams(String message, Map<String, String> params) {
        // replace params in message
        if (!CollectionUtils.isEmpty(params)) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                message = message.replaceAll("%%" + param.getKey() + "%%", param.getValue());
            }
        }
        // replace general params
        if (!CollectionUtils.isEmpty(messageResponseConfig.getParams())) {
            for (Map.Entry<String, String> param : messageResponseConfig.getParams().entrySet()) {
                message = message.replaceAll("%%" + param.getKey() + "%%", param.getValue());
            }
        }
        return message;
    }

    /**
     * Parsing status code & message to response object
     */
    private ResponseStatus parseResponseStatus(String code,
                                               Map<String, String> params) {
        ResponseStatus responseStatus = new ResponseStatus(code);
        responseStatus.setMessage(replaceParams(responseStatus.getMessage(), params));
        // náº¿u cáº§n láº¥y msg á»Ÿ bÃªn ngoÃ i, vÃ­ dá»¥ database..etc.. thÃ¬ client  Impl interface ErrorService
        String errorDetail = null;
        if (Objects.nonNull(errorService)) {
            errorDetail = errorService
                    .getErrorDetail(code, LocaleContextHolder.getLocale().getLanguage());
        }
        if (Objects.nonNull(errorDetail)) {
            // replace params to display message
            responseStatus.setDisplayMessage(replaceParams(errorDetail, params));
        } else {
            responseStatus.setDisplayMessage(responseStatus.getMessage());
        }

        log.debug(responseStatus.toString());

        return responseStatus;
    }

    /**
     * Response status code SUCCESS
     */
    public <T> ResponseEntity<BaseResponse<T>> success(T data) {
        BaseResponse<T> responseObject = new BaseResponse<>();
        responseObject.setData(data);
        return success(responseObject);
    }

    public <T> ResponseEntity<BaseResponse<T>> success(BaseResponse<T> responseObject) {
        ResponseStatus responseStatus = parseResponseStatus(Constants.REQUEST_SUCCESS.getCode(), null);
        responseObject.setStatus(responseStatus);
        return ResponseEntity.ok().body(responseObject);
    }

    /**
     * Response SUCCESS with header
     */
    public <T> ResponseEntity<BaseResponse<T>> successWithHeader(MultiValueMap<String, String> header, T data) {
        BaseResponse<T> responseObject = new BaseResponse<>();
        responseObject.setData(data);

        ResponseStatus responseStatus = parseResponseStatus(Constants.REQUEST_SUCCESS.getCode(), null);

        responseObject.setStatus(responseStatus);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.addAll(header);
        return ResponseEntity.ok().headers(responseHeaders).body(responseObject);
    }

    /**
     * Response with status code not equals SUCCESS
     */
    public <T> ResponseEntity<BaseResponse<T>> fail(T data, ResponseStatusCode code) {
        BaseResponse<T> responseObject = new BaseResponse<>();
        responseObject.setData(data);
        return fail(responseObject, code, null);
    }
    public <T> ResponseEntity<BaseResponse<T>> fail(ResponseStatusCode code) {
        BaseResponse<T> responseObject = new BaseResponse<>();
        return fail(responseObject, code, null);
    }

    public <T> ResponseEntity<BaseResponse<T>> fail(BaseResponse<T> responseObject, ResponseStatusCode code) {
        if(Objects.isNull(responseObject)){
            responseObject = new BaseResponse<>();
        }
        return fail(responseObject, code, null);
    }

    public <T> ResponseEntity<BaseResponse<T>> fail(BaseResponse<T> responseObject, ResponseStatusCode code,
                                                       Map<String, String> params) {
        ResponseStatus responseStatus = parseResponseStatus(code.getCode(), params);

        responseObject.setStatus(responseStatus);
        return ResponseEntity.status(code.getHttpCode()).body(responseObject);
    }

    /**
     * Response on filter
     */
    public <T> void httpServletResponseToClient(HttpServletResponse httpServletResponse, T data,
                                                ResponseStatusCode statusCode) throws IOException {
        httpServletResponseToClient(httpServletResponse, data, statusCode, null);
    }

    public <T> void httpServletResponseToClient(HttpServletResponse httpServletResponse, T data,
                                                ResponseStatusCode statusCode, Map<String, String> params) throws IOException {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(data);
        ResponseStatus responseStatus = parseResponseStatus(statusCode.getCode(), params);
        response.setStatus(responseStatus);
        writeToHttpServletResponse(httpServletResponse, response, statusCode);
    }

    public void writeToHttpServletResponse(HttpServletResponse httpServletResponse, Object response,
                                           ResponseStatusCode statusCode) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String responseString = mapper.writeValueAsString(response);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.setStatus(statusCode.getHttpCode());
        httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE,
                MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.getWriter().write(responseString);
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }

}
