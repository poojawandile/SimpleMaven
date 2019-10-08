package com.myapp.toggle;

import java.io.File;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;
import org.togglz.servlet.user.ServletUserProvider;
import com.myapp.bl.PropertyLoader;

public class MyTogglzConfiguration implements TogglzConfig {

	PropertyLoader pl = new PropertyLoader();	
    public Class<? extends Feature> getFeatureClass() {
        return MyFeatures.class;
    }

    public StateRepository getStateRepository() {
    	System.out.println(" *********8 88888 8  In getStateRepository() 999999 ");
    	return new FileBasedStateRepository(new File("D:\\NewGitRepo\\SimpleMavenProj\\devopsdemo\\src\\main\\resources\\features.properties"));
    }

    @Override
    public UserProvider getUserProvider() {
        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                return new SimpleFeatureUser("admin", true);
            }
        };
    }

}