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

package com.crypto.login;

import com.crypto.auth.SecurityProvider;

import com.db.JpaSimpleService;
import com.db.jpa.EMFProducer;
import com.db.User;
import com.db.jpa.JpaTransactionManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validation;
import lombok.*;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import javax.persistence.EntityManager;

import java.util.Map;
import java.util.Objects;

@Data
public class Login extends AuthTrait {

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String email;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String password;

    @Override
    public String execute() throws Exception {

        if(jpaSimpleService.runLoginTest(email, password)) {
            sessionMap.put(SecurityProvider.getInstance().getUserKey(), JpaSimpleService.getSessionUser());
        }

        return SUCCESS;
    }

    @SkipValidation
    public String input() {
        return INPUT;
    }

    public String register() {

        if(email != null && password != null ) {
            User usrsF =   jpaSimpleService.createUser(email,password );
            if(Objects.nonNull(usrsF)){
                return SUCCESS;
            } else {
                return "error";
            }

        } else {
            return "error";
        }
    }

    @Override
    public void validate() {
        if (email.trim().equals("")) {
            String errorMsg = "You must provide an Email Address!";
            addActionError(errorMsg);
        }
        if (password.trim().equals("")) {
            String errorMsg = "You must provide a Password Address!";
            addActionError(errorMsg);
        }
    }

}
