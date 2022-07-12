package fpt.template.templateservice.config.properties;

import com.zaxxer.hikari.HikariConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
    prefix = "app"
)
public class AppConfigurationProperties {
    @Value("${app.application-short-name}")
    private String applicationShortName;
    @Value("${app.application-context-name}")
    private String applicationContextName;
    @Value("${app.log-request-http:#{false}}")
    private boolean logRequestHttp;
    @Value("${app.default-service-enable-log-request:#{false}}")
    private boolean defaultServiceEnableLogRequest = false;
    @Value("${app.repository-query-limit-warning-ms:30}")
    private int repositoryQueryLimitWarningMs;
    private int asyncExecutorCorePoolSize = 2;
    private int asyncExecutorMaxPoolSize = 4;
    private List<String> localeResolverLanguages = Arrays.asList("en", "vi");
    private String defaultLanguage = "vi";
    @Value("${app.log-graphql-enabled:#{false}}")
    private boolean logGraphqlEnabled;
    @Value("${app.time-trace-enabled:#{false}}")
    private boolean timeTraceEnabled;
    private String asyncExecutorThreadNamePrefix = "Async-";
    private Map<String, AppConfigurationProperties.BaseDataSourceProperties> datasource;

    public AppConfigurationProperties() {
    }

    public String getApplicationShortName() {
        return this.applicationShortName;
    }

    public String getApplicationContextName() {
        return this.applicationContextName;
    }

    public boolean isLogRequestHttp() {
        return this.logRequestHttp;
    }

    public boolean isDefaultServiceEnableLogRequest() {
        return this.defaultServiceEnableLogRequest;
    }

    public int getRepositoryQueryLimitWarningMs() {
        return this.repositoryQueryLimitWarningMs;
    }

    public int getAsyncExecutorCorePoolSize() {
        return this.asyncExecutorCorePoolSize;
    }

    public int getAsyncExecutorMaxPoolSize() {
        return this.asyncExecutorMaxPoolSize;
    }

    public List<String> getLocaleResolverLanguages() {
        return this.localeResolverLanguages;
    }

    public String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public boolean isLogGraphqlEnabled() {
        return this.logGraphqlEnabled;
    }

    public boolean isTimeTraceEnabled() {
        return this.timeTraceEnabled;
    }

    public String getAsyncExecutorThreadNamePrefix() {
        return this.asyncExecutorThreadNamePrefix;
    }

    public Map<String, AppConfigurationProperties.BaseDataSourceProperties> getDatasource() {
        return this.datasource;
    }

    public void setApplicationShortName(final String applicationShortName) {
        this.applicationShortName = applicationShortName;
    }

    public void setApplicationContextName(final String applicationContextName) {
        this.applicationContextName = applicationContextName;
    }

    public void setLogRequestHttp(final boolean logRequestHttp) {
        this.logRequestHttp = logRequestHttp;
    }

    public void setDefaultServiceEnableLogRequest(final boolean defaultServiceEnableLogRequest) {
        this.defaultServiceEnableLogRequest = defaultServiceEnableLogRequest;
    }

    public void setRepositoryQueryLimitWarningMs(final int repositoryQueryLimitWarningMs) {
        this.repositoryQueryLimitWarningMs = repositoryQueryLimitWarningMs;
    }

    public void setAsyncExecutorCorePoolSize(final int asyncExecutorCorePoolSize) {
        this.asyncExecutorCorePoolSize = asyncExecutorCorePoolSize;
    }

    public void setAsyncExecutorMaxPoolSize(final int asyncExecutorMaxPoolSize) {
        this.asyncExecutorMaxPoolSize = asyncExecutorMaxPoolSize;
    }

    public void setLocaleResolverLanguages(final List<String> localeResolverLanguages) {
        this.localeResolverLanguages = localeResolverLanguages;
    }

    public void setDefaultLanguage(final String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public void setLogGraphqlEnabled(final boolean logGraphqlEnabled) {
        this.logGraphqlEnabled = logGraphqlEnabled;
    }

    public void setTimeTraceEnabled(final boolean timeTraceEnabled) {
        this.timeTraceEnabled = timeTraceEnabled;
    }

    public void setAsyncExecutorThreadNamePrefix(final String asyncExecutorThreadNamePrefix) {
        this.asyncExecutorThreadNamePrefix = asyncExecutorThreadNamePrefix;
    }

    public void setDatasource(final Map<String, AppConfigurationProperties.BaseDataSourceProperties> datasource) {
        this.datasource = datasource;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AppConfigurationProperties)) {
            return false;
        } else {
            AppConfigurationProperties other = (AppConfigurationProperties)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label111: {
                    Object this$applicationShortName = this.getApplicationShortName();
                    Object other$applicationShortName = other.getApplicationShortName();
                    if (this$applicationShortName == null) {
                        if (other$applicationShortName == null) {
                            break label111;
                        }
                    } else if (this$applicationShortName.equals(other$applicationShortName)) {
                        break label111;
                    }

                    return false;
                }

                Object this$applicationContextName = this.getApplicationContextName();
                Object other$applicationContextName = other.getApplicationContextName();
                if (this$applicationContextName == null) {
                    if (other$applicationContextName != null) {
                        return false;
                    }
                } else if (!this$applicationContextName.equals(other$applicationContextName)) {
                    return false;
                }

                if (this.isLogRequestHttp() != other.isLogRequestHttp()) {
                    return false;
                } else if (this.isDefaultServiceEnableLogRequest() != other.isDefaultServiceEnableLogRequest()) {
                    return false;
                } else if (this.getRepositoryQueryLimitWarningMs() != other.getRepositoryQueryLimitWarningMs()) {
                    return false;
                } else if (this.getAsyncExecutorCorePoolSize() != other.getAsyncExecutorCorePoolSize()) {
                    return false;
                } else if (this.getAsyncExecutorMaxPoolSize() != other.getAsyncExecutorMaxPoolSize()) {
                    return false;
                } else {
                    label90: {
                        Object this$localeResolverLanguages = this.getLocaleResolverLanguages();
                        Object other$localeResolverLanguages = other.getLocaleResolverLanguages();
                        if (this$localeResolverLanguages == null) {
                            if (other$localeResolverLanguages == null) {
                                break label90;
                            }
                        } else if (this$localeResolverLanguages.equals(other$localeResolverLanguages)) {
                            break label90;
                        }

                        return false;
                    }

                    Object this$defaultLanguage = this.getDefaultLanguage();
                    Object other$defaultLanguage = other.getDefaultLanguage();
                    if (this$defaultLanguage == null) {
                        if (other$defaultLanguage != null) {
                            return false;
                        }
                    } else if (!this$defaultLanguage.equals(other$defaultLanguage)) {
                        return false;
                    }

                    if (this.isLogGraphqlEnabled() != other.isLogGraphqlEnabled()) {
                        return false;
                    } else if (this.isTimeTraceEnabled() != other.isTimeTraceEnabled()) {
                        return false;
                    } else {
                        label73: {
                            Object this$asyncExecutorThreadNamePrefix = this.getAsyncExecutorThreadNamePrefix();
                            Object other$asyncExecutorThreadNamePrefix = other.getAsyncExecutorThreadNamePrefix();
                            if (this$asyncExecutorThreadNamePrefix == null) {
                                if (other$asyncExecutorThreadNamePrefix == null) {
                                    break label73;
                                }
                            } else if (this$asyncExecutorThreadNamePrefix.equals(other$asyncExecutorThreadNamePrefix)) {
                                break label73;
                            }

                            return false;
                        }

                        Object this$datasource = this.getDatasource();
                        Object other$datasource = other.getDatasource();
                        if (this$datasource == null) {
                            if (other$datasource != null) {
                                return false;
                            }
                        } else if (!this$datasource.equals(other$datasource)) {
                            return false;
                        }

                        return true;
                    }
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AppConfigurationProperties;
    }

    public String toString() {
        return "AppConfigurationProperties(applicationShortName=" + this.getApplicationShortName() + ", applicationContextName=" + this.getApplicationContextName() + ", logRequestHttp=" + this.isLogRequestHttp() + ", defaultServiceEnableLogRequest=" + this.isDefaultServiceEnableLogRequest() + ", repositoryQueryLimitWarningMs=" + this.getRepositoryQueryLimitWarningMs() + ", asyncExecutorCorePoolSize=" + this.getAsyncExecutorCorePoolSize() + ", asyncExecutorMaxPoolSize=" + this.getAsyncExecutorMaxPoolSize() + ", localeResolverLanguages=" + this.getLocaleResolverLanguages() + ", defaultLanguage=" + this.getDefaultLanguage() + ", logGraphqlEnabled=" + this.isLogGraphqlEnabled() + ", timeTraceEnabled=" + this.isTimeTraceEnabled() + ", asyncExecutorThreadNamePrefix=" + this.getAsyncExecutorThreadNamePrefix() + ", datasource=" + this.getDatasource() + ")";
    }

    public class BaseDataSourceProperties extends DataSourceProperties {
        private Map<String, String> properties = new HashMap();
        private HikariConfig configuration;

        public Map<String, String> getProperties() {
            return this.properties;
        }

        public void setProperties(Map<String, String> properties) {
            this.properties = properties;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof AppConfigurationProperties.BaseDataSourceProperties)) {
                return false;
            } else {
                AppConfigurationProperties.BaseDataSourceProperties other = (AppConfigurationProperties.BaseDataSourceProperties)o;
                if (!other.canEqual(this)) {
                    return false;
                } else if (!super.equals(o)) {
                    return false;
                } else {
                    Object this$properties = this.getProperties();
                    Object other$properties = other.getProperties();
                    if (this$properties == null) {
                        if (other$properties != null) {
                            return false;
                        }
                    } else if (!this$properties.equals(other$properties)) {
                        return false;
                    }

                    Object this$configuration = this.getConfiguration();
                    Object other$configuration = other.getConfiguration();
                    if (this$configuration == null) {
                        if (other$configuration != null) {
                            return false;
                        }
                    } else if (!this$configuration.equals(other$configuration)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof AppConfigurationProperties.BaseDataSourceProperties;
        }

        public BaseDataSourceProperties() {
        }

        public HikariConfig getConfiguration() {
            return this.configuration;
        }

        public void setConfiguration(final HikariConfig configuration) {
            this.configuration = configuration;
        }

        public String toString() {
            return "AppConfigurationProperties.BaseDataSourceProperties(properties=" + this.getProperties() + ", configuration=" + this.getConfiguration() + ")";
        }
    }
}
