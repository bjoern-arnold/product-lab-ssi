/********************************************************************************
 * Copyright (c) 2021,2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

package org.eclipse.tractusx.ssi.lib.crypt.jwk;

import java.io.IOException;
import org.eclipse.tractusx.ssi.lib.did.resolver.OctetKeyPairFactory;

import com.nimbusds.jose.jwk.OctetKeyPair;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonWebKey {
  private final OctetKeyPair keyPair;
  

  public static JsonWebKey fromED21559(String id,byte [] publicKey,byte[] privateKey) throws IOException {
    OctetKeyPairFactory keyPairFactory = new OctetKeyPairFactory();
    OctetKeyPair keyOctetKeyPair = keyPairFactory.fromKeyPairWithKeyID(id,publicKey, privateKey);

    return new JsonWebKey(keyOctetKeyPair);
  }

  public String getCurv(){
    return keyPair.getCurve().getName();
  }

  public String getKeyID(){
    return keyPair.getKeyID();
  }

  public String getKeyType(){
    return this.keyPair.getKeyType().getValue();
  }

  public String getX(){
    return this.keyPair.getX().toString();
  }

}

  
