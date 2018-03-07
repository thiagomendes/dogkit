package br.com.dogkit.persistence.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource("file:/aplic/dogkit/configuration/mysql_configuration.properties")
public class MysqlConfiguration {

	/*@Value("${url}")
	private String url;

	@Value("${usuario}")
	private String usuario;

	@Value("${senha}")
	private String senha;

	@Value("${driver}")
	private String driver;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}*/
}
