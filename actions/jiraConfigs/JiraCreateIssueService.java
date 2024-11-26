package jiraConfigs;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface JiraCreateIssueService {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface JiraCreateIssue {
        boolean isCreateIssue();
    }

}


