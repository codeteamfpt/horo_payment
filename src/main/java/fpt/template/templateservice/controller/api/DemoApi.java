package fpt.template.templateservice.controller.api;


import fpt.template.templateservice.dto.request.DemoRequestDTO;
import fpt.template.templateservice.dto.response.DemoResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "demo", name = "tên request")
@Tag(name = "tên request", description = "định nghĩa request")
public interface DemoApi {

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "tổng quan tác dụng api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Lỗi xác thực"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy")
    })
    DemoResponseDTO getDemo(
            @Parameter(name = "Authentication", in = ParameterIn.HEADER, required = true, description = "token", example = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIwMUU0OEpWVldaV0oyUDNFRU1ON1ZTV1g4NiIsImF1ZCI6IlRISVJEX1BBUlRZIiwidXNyIjoiVVNTREFQUCIsInJvbGVzIjpbIlRISVJEX1BBUlRZIiwiUkVHSVNURVJfTU0iLCJBRE1JTiJdLCJ0eXBlIjoiM1JEX1RPS0VOIiwiaWF0IjoxNjAwMDc1NzMwLCJleHAiOjE2MDUyNTk3MzAsImp0aSI6IjAxRUo1WjQ3RlNBRVdTM1RSQTZNRkIwWVE0In0.eBRDjrmh1fVX88td8sRNoDAnNGpmg3vaWNTlBI9uBYZz2rkJq8lbUGkpB/fyiBrNcTTesG54usA3Jc1AmMkGENa1zOwOKJkerZ0I9l5RU58Y3q3p/pGlrNGk9lJ180K9VRYfXGyRdr/1+5G3L09rzUiUAOjmCqAuBPE2oj9T+cW9ajOu4JZ8IqDTvh/BIQ3bKUxCT1nav296CG3Coqs6GrqBSEsygTCVxWI+FIbCHuIW5iRSNkSqigh9nwTy0dih8A+gGpc3w946Y8zC2ysqnnEHQAkvt6TkFdsO3l0T+YcEMPkkHj2FMfpNsOtm33rYZPIssB06+S1MDFZc212aVEzx8VUhFO3J/ZjqR9aHdpsLFsV7V0H6b6RIHikG+umUYneHfrokvPZGU8gzvg4Cjl3NnZjmu9vTF7a/Q9Hgp98bSAaIK6I1bi+W7L9NrmLp69/apn7PxHJnvWlojs8is/09cUwINF/HILmDeviRAVjK2oUuA5pmMIBY9ivxFgqH8HqDDaPJfL61WxVRBgFaADbMX9Uv71E7Op4gk+lPH5e5jjOwoNnmSJxdspjiXZHjRFiSXPCE7sxhHClWXcYWhqyCn6QulQW5DbB1m8dhmH3cu/rHO2sbL4PfKJam1gxT1B/eZ8SJFWpu61uKNt9TNThbwC+9gbIZQIgJqq0l6hw=") String authentication,
            @Parameter(name = "msisdn", in = ParameterIn.QUERY, required = true, description = "Số điện thoại khách hàng", example = "84971888393") String msisdn,
            @Parameter(name = "requestId", in = ParameterIn.QUERY, required = true, description = "Mã giao dịch", example = "20052015203") String requestId);

    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "tổng quan tác dụng api")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Lỗi xác thực"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy") })
    DemoResponseDTO postDemo(
            @Parameter(name = "Authentication", in = ParameterIn.HEADER, required = true, description = "token", example = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIwMUU0OEpWVldaV0oyUDNFRU1ON1ZTV1g4NiIsImF1ZCI6IlRISVJEX1BBUlRZIiwidXNyIjoiVVNTREFQUCIsInJvbGVzIjpbIlRISVJEX1BBUlRZIiwiUkVHSVNURVJfTU0iLCJBRE1JTiJdLCJ0eXBlIjoiM1JEX1RPS0VOIiwiaWF0IjoxNjAwMDc1NzMwLCJleHAiOjE2MDUyNTk3MzAsImp0aSI6IjAxRUo1WjQ3RlNBRVdTM1RSQTZNRkIwWVE0In0.eBRDjrmh1fVX88td8sRNoDAnNGpmg3vaWNTlBI9uBYZz2rkJq8lbUGkpB/fyiBrNcTTesG54usA3Jc1AmMkGENa1zOwOKJkerZ0I9l5RU58Y3q3p/pGlrNGk9lJ180K9VRYfXGyRdr/1+5G3L09rzUiUAOjmCqAuBPE2oj9T+cW9ajOu4JZ8IqDTvh/BIQ3bKUxCT1nav296CG3Coqs6GrqBSEsygTCVxWI+FIbCHuIW5iRSNkSqigh9nwTy0dih8A+gGpc3w946Y8zC2ysqnnEHQAkvt6TkFdsO3l0T+YcEMPkkHj2FMfpNsOtm33rYZPIssB06+S1MDFZc212aVEzx8VUhFO3J/ZjqR9aHdpsLFsV7V0H6b6RIHikG+umUYneHfrokvPZGU8gzvg4Cjl3NnZjmu9vTF7a/Q9Hgp98bSAaIK6I1bi+W7L9NrmLp69/apn7PxHJnvWlojs8is/09cUwINF/HILmDeviRAVjK2oUuA5pmMIBY9ivxFgqH8HqDDaPJfL61WxVRBgFaADbMX9Uv71E7Op4gk+lPH5e5jjOwoNnmSJxdspjiXZHjRFiSXPCE7sxhHClWXcYWhqyCn6QulQW5DbB1m8dhmH3cu/rHO2sbL4PfKJam1gxT1B/eZ8SJFWpu61uKNt9TNThbwC+9gbIZQIgJqq0l6hw=") String authentication,
            @RequestBody DemoRequestDTO demoRequestDTO);
}

