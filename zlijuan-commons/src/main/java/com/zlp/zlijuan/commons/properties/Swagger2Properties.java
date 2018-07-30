package com.zlp.zlijuan.commons.properties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Title: 接收swagger2配置文件
 * @ClassName: Swagger2Properties.java  
 * @Package: com.zlp.zlijuan.commons.properties
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:03:24
 * @version: V1.0
 */
@PropertySource(value = "classpath:properties/swagger2.properties")
@ConfigurationProperties(prefix = "swagger2")
@Component
public class Swagger2Properties {

	private List<String> protocols = new ArrayList<>();

	private String host;

	private boolean enable = true;

	private String basePackage;

	private ApiInfo apiInfo = new ApiInfo();

	public List<String> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<String> protocols) {
		this.protocols = protocols;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public ApiInfo getApiInfo() {
		return apiInfo;
	}

	public void setApiInfo(ApiInfo apiInfo) {
		this.apiInfo = apiInfo;
	}

	public class ApiInfo {
		private String version;
		private String title;
		private String description;
		private String termsOfServiceUrl;
		private String license;
		private String licenseUrl;
		private Contact contact = new Contact();

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTermsOfServiceUrl() {
			return termsOfServiceUrl;
		}

		public void setTermsOfServiceUrl(String termsOfServiceUrl) {
			this.termsOfServiceUrl = termsOfServiceUrl;
		}

		public String getLicense() {
			return license;
		}

		public void setLicense(String license) {
			this.license = license;
		}

		public String getLicenseUrl() {
			return licenseUrl;
		}

		public void setLicenseUrl(String licenseUrl) {
			this.licenseUrl = licenseUrl;
		}

		public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

		public class Contact {
			private String name;
			private String url;
			private String email;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}
		}
	}
}
