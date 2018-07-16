/*
 * © Copyright 2013 EntIT Software LLC
 *  Certain versions of software and/or documents (“Material”) accessible here may contain branding from
 *  Hewlett-Packard Company (now HP Inc.) and Hewlett Packard Enterprise Company.  As of September 1, 2017,
 *  the Material is now offered by Micro Focus, a separately owned and operated company.  Any reference to the HP
 *  and Hewlett Packard Enterprise/HPE marks is historical in nature, and the HP and Hewlett Packard Enterprise/HPE
 *  marks are the property of their respective owners.
 * __________________________________________________________________
 * MIT License
 *
 * © Copyright 2012-2018 Micro Focus or one of its affiliates.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors (“Micro Focus”) are set forth in the express warranty statements
 * accompanying such products and services. Nothing herein should be construed as
 * constituting an additional warranty. Micro Focus shall not be liable for technical
 * or editorial errors or omissions contained herein.
 * The information contained herein is subject to change without notice.
 * ___________________________________________________________________
 *
 */

package com.microfocus.application.automation.tools.octane.executor;

import com.microfocus.application.automation.tools.octane.AbstractResultQueueImpl;
import jenkins.model.Jenkins;

import java.io.File;
import java.io.IOException;

/**
 * Queue for jenkins coverage reports before dispatching
 */
public class CoverageReportsQueue extends AbstractResultQueueImpl {

    public CoverageReportsQueue(int maxRetries) throws IOException {
        super(maxRetries);
        Jenkins jenkinsContainer = Jenkins.getInstance();
        if (jenkinsContainer != null) {
            File queueFile = new File(jenkinsContainer.getRootDir(), "coverage-reports-queue.dat");
            init(queueFile);
        } else {
            throw new IllegalStateException("Jenkins container not initialized properly");
        }
    }

}
