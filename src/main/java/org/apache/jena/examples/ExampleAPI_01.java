/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.examples;

import org.apache.jena.rdf.model.*;
// import org.apache.jena.util.FileManager;
import org.apache.jena.riot.RDFDataMgr;

import java.io.InputStream;

public class ExampleAPI_01 {

    public static void main(String[] args) {
        /*FileManager.get().addLocatorClassLoader(ExampleAPI_01.class.getClassLoader());
        Model model = FileManager.get().loadModel("data/data.ttl", null, "TURTLE");*/ // deprecated

        Model model = RDFDataMgr.loadModel("data/data.ttl");


        StmtIterator iter = model.listStatements(); //An iterator which returns RDF Statements.
        try {
            while ( iter.hasNext() ) {
                Statement stmt = iter.next();
                
                Resource s = stmt.getSubject();
                Property p = stmt.getPredicate(); // 原版：Resource p = stmt.getPredicate();
                RDFNode o = stmt.getObject();
                
                if ( s.isURIResource() ) {
                    System.out.print("URI");
                } else if ( s.isAnon() ) {
                    System.out.print("blank");
                }
                
                if ( p.isURIResource() ) 
                    System.out.print(" URI ");
                
                if ( o.isURIResource() ) {
                    System.out.print("URI");
                } else if ( o.isAnon() ) {
                    System.out.print("blank");
                } else if ( o.isLiteral() ) {
                    System.out.print("literal");
                }
                
                System.out.println();                
            }
        } finally {
            if ( iter != null ) iter.close();
        }
    }

}
