package computerdatabase.configuration;

import configuration.WebdriverConfig;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({WebdriverConfig.class})
@ComponentScan("pages")
@ComponentScan("datacontainer")
@PropertySources({
        @PropertySource("classpath:config.properties")
})
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
