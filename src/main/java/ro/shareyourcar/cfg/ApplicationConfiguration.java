package ro.shareyourcar.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ro.shareyourcar.dao.CarDAO;
import ro.shareyourcar.dao.OwnerDAO;
import ro.shareyourcar.dao.db.JDBCCarDAO;
import ro.shareyourcar.dao.db.JDBCOwnerDAO;

@Configuration
@RequestMapping("/")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/403").setViewName("403");
		registry.addViewController("/done").setViewName("done");

	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");

		String url = new StringBuilder().append("jdbc:").append("postgresql").append("://").append("localhost")
				.append(":").append("5432").append("/").append("Shareyourcar").toString();

		dataSource.setUrl(url);
		dataSource.setUsername("postgres");
		dataSource.setPassword("Z80Spectrum");
		return dataSource;

	}

	@Bean
	public OwnerDAO ownerDAO() {

		return new JDBCOwnerDAO("localhost", "5432", "Shareyourcar", "postgres", "Z80Spectrum");
	}

	@Bean
	public CarDAO carDAO() {

		return new JDBCCarDAO("localhost", "5432", "Shareyourcar", "postgres", "Z80Spectrum");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
