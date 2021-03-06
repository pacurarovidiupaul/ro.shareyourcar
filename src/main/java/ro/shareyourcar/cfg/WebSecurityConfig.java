package ro.shareyourcar.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select user_name, password, enabled from public.users where user_name=?")
				.authoritiesByUsernameQuery("select user_name, role from public.user_role where user_name=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/owner/add").permitAll().antMatchers("/client/add").permitAll()

				.antMatchers("/owner").access("hasRole('ROLE_OWNER')").antMatchers("/owner/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/owner/edit").access("hasRole('ROLE_OWNER')").antMatchers("/owner/edit/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/owner/update").access("hasRole('ROLE_OWNER')").antMatchers("/owner/update/")
				.access("hasRole('ROLE_OWNER')")
				
				.antMatchers("/owner/showpos").access("hasRole('ROLE_OWNER')").antMatchers("/owner/showpos/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/car/show").access("hasRole('ROLE_ADMIN')").antMatchers("/car/show/")
				.access("hasRole('ROLE_ADMIN')")

				.antMatchers("/car/save").access("hasRole('ROLE_OWNER')").antMatchers("/car/save/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/car/add").access("hasRole('ROLE_OWNER')").antMatchers("/car/add/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/car/list").access("hasRole('ROLE_OWNER')").antMatchers("/car/list/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/car/edit").access("hasRole('ROLE_OWNER')").antMatchers("/car/edit/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/car/update").access("hasRole('ROLE_OWNER')").antMatchers("/car/update/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/car/delete").access("hasRole('ROLE_OWNER')").antMatchers("/car/delete/")
				.access("hasRole('ROLE_OWNER')")

				.antMatchers("/car/available").access("hasRole('ROLE_CLIENT')").antMatchers("/car/available/")
				.access("hasRole('ROLE_CLIENT')")

				.antMatchers("/car/booked").access("hasRole('ROLE_CLIENT')").antMatchers("/car/booked/")
				.access("hasRole('ROLE_CLIENT')")

				.antMatchers("/car/unbook").access("hasRole('ROLE_CLIENT')").antMatchers("/car/unbook/")
				.access("hasRole('ROLE_CLIENT')")

				.antMatchers("/car/book").access("hasRole('ROLE_CLIENT')").antMatchers("/car/book/")
				.access("hasRole('ROLE_CLIENT')")
				
				.antMatchers("/car/showpos").access("hasRole('ROLE_CLIENT')").antMatchers("/car/showpos/")
				.access("hasRole('ROLE_CLIENT')")
				
				.antMatchers("/car/showroute").access("hasRole('ROLE_CLIENT')").antMatchers("/car/showroute/")
				.access("hasRole('ROLE_CLIENT')")

				.antMatchers("/client").access("hasRole('ROLE_CLIENT')").antMatchers("/client/")
				.access("hasRole('ROLE_CLIENT')")

				.antMatchers("/client/edit").access("hasRole('ROLE_CLIENT')").antMatchers("/client/edit/")
				.access("hasRole('ROLE_CLIENT')")

				.antMatchers("/client/update").access("hasRole('ROLE_CLIENT')").antMatchers("/client/update/")
				.access("hasRole('ROLE_CLIENT')")

				.anyRequest().permitAll().and().formLogin().loginPage("/login").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/login?logout").and()
				.exceptionHandling().accessDeniedPage("/403").and().csrf().disable();

	}

}
