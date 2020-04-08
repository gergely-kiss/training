package uk.gergely.kiss.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import com.google.common.base.Predicate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import uk.gergely.kiss.training.api.resources.ControllerConstants;


@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableAsync
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager(){
		return new CaffeineCacheManager("greetingEntitys");
	}

	@Bean
	public Docket apiRoot() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(paths()).apis(RequestHandlerSelectors.any())
				.build().apiInfo(getApiInfo()).useDefaultResponseMessages(false);
	}

	private Predicate<String> paths() {
		return regex(ControllerConstants.API_ROOT + ControllerConstants.REGEX_ALL);
	}

	private Contact getContactDetails() {
		return new Contact(ControllerConstants.CONTACT_NAME, ControllerConstants.CONTACT_URL,
				ControllerConstants.CONTACT_EMAIL);
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title(ControllerConstants.TRAINING_SERVICE_TITLE)
				.version(ControllerConstants.TRAINING_SERVICE_VERSION).contact(getContactDetails()).build();
	}
}
