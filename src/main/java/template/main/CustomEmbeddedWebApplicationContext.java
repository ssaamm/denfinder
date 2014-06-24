package template.main;

import org.springframework.boot.context.embedded.XmlEmbeddedWebApplicationContext;
import org.springframework.core.io.Resource;

public class CustomEmbeddedWebApplicationContext extends XmlEmbeddedWebApplicationContext {
	public CustomEmbeddedWebApplicationContext(Resource resource) {
		this.load(resource);
	}
}
