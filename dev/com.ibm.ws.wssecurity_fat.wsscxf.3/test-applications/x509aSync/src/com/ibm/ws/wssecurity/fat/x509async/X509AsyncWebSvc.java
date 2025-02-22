/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.wssecurity.fat.x509async;

import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-04-22T21:55:02.364-05:00
 * Generated source version: 2.6.2
 *
 */

@javax.jws.WebService(
                      serviceName = "X509AsyncService",
                      portName = "X509AsyncPort",
                      targetNamespace = "http://x509async.wssecfvt.test",
                      wsdlLocation = "WEB-INF/X509Async.wsdl")
//,
// endpointInterface = "test.wssecfvt.x509async.UrnX509AsyncType")

public class X509AsyncWebSvc {

    //private static final Logger LOG = Logger.getLogger(UrnX509AsyncTypeImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see test.wssecfvt.x509async.UrnX509AsyncType#invokeAsync(test.wssecfvt.x509async.types.RequestString getVersion )*
     */
    public Response<test.wssecfvt.x509async.types.ResponseString> invokeAsync(test.wssecfvt.x509async.types.RequestString getVersion) {
        System.out.println("In X509AsyncWebSvc, Executing operation invokeAsync");
        System.out.println("getVersion: ");
        System.out.println(getVersion);
        return null;
        /* not called */
    }

    /*
     * (non-Javadoc)
     * 
     * @see test.wssecfvt.x509async.UrnX509AsyncType#invokeAsync(test.wssecfvt.x509async.types.RequestString getVersion ,)AsyncHandler<test.wssecfvt.x509async.types.ResponseString>
     * asyncHandler )*
     */
    public Future<?> invokeAsync(test.wssecfvt.x509async.types.RequestString getVersion, AsyncHandler<test.wssecfvt.x509async.types.ResponseString> asyncHandler) {
        System.out.println("In X509AsyncWebSvc, Executing operation invokeAsync callback");
        System.out.println("getVersion: ");
        System.out.println(getVersion);
        return null;
        /* not called */
    }

    /*
     * (non-Javadoc)
     * 
     * @see test.wssecfvt.x509async.UrnX509AsyncType#invoke(test.wssecfvt.x509async.types.RequestString getVersion )*
     */
    public test.wssecfvt.x509async.types.ResponseString invoke(test.wssecfvt.x509async.types.RequestString getVersion) {
        System.out.println("In X509AsyncWebSvc, Executing operation invoke");
        System.out.println("getVersion: ");
        System.out.println(getVersion);
        try {
            test.wssecfvt.x509async.types.ResponseString response = null;
            //test.wssecfvt.x509async.types.ResponseString response = new test.wssecfvt.x509async.types.ResponseString() ;
            //response.setStringres("This is WSSECFVT CXF X509AsyncService") ;
            return response;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
