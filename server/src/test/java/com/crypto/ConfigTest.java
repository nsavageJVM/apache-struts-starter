/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.crypto;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.providers.XmlConfigurationProvider;
import org.apache.struts2.StrutsJUnit4TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;


public class ConfigTest extends StrutsJUnit4TestCase {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;



    protected void assertSuccess(String result) throws Exception {
        assertTrue("Expected a success result!",
                ActionSupport.SUCCESS.equals(result));
    }

    public void setUp() throws Exception {
        super.setUp();
        XmlConfigurationProvider c = new XmlConfigurationProvider("struts.xml");
        configurationManager.addContainerProvider(c);
        configurationManager.reload();
    }


    public void testConfig() throws Exception {
        assertNotNull(configurationManager);
    }

}
