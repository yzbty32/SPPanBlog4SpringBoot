package net.sppan.blog.config;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import net.sppan.blog.directive.BlogDirective;
import net.sppan.blog.directive.CategoryDirective;
import net.sppan.blog.directive.TagDirective;
import net.sppan.blog.directive.YoulianDirective;

@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;
    
    @Resource
    private CategoryDirective categoryDirective;
    @Resource
    private BlogDirective blogDirective;
    @Resource
    private TagDirective tagDirective;
    @Resource
    private YoulianDirective youlianDirective;
    
    @PostConstruct
    public void setSharedVariable() {
    	try {
			configuration.setSharedVariable("categoryList", categoryDirective);
			configuration.setSharedVariable("blogList", blogDirective);
			configuration.setSharedVariable("tagList", tagDirective);
			configuration.setSharedVariable("youlianList", youlianDirective);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
