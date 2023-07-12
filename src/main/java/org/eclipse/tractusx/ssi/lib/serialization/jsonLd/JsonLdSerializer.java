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

package org.eclipse.tractusx.ssi.lib.serialization.jsonLd;

import org.eclipse.tractusx.ssi.lib.exception.InvalidJsonLdException;
import org.eclipse.tractusx.ssi.lib.model.verifiable.presentation.VerifiablePresentation;
import org.eclipse.tractusx.ssi.lib.serialization.jwt.SerializedVerifiablePresentation;

public interface JsonLdSerializer {

  /**
   * Serlizer a presentation to a Json string
   *
   * @param verifiablePresentation
   * @return {@link SerializedVerifiablePresentation}
   */
  SerializedVerifiablePresentation serializePresentation(
      VerifiablePresentation verifiablePresentation);

  /**
   * Deserialize a presentation with options to validate JSON-LD or not.
   *
   * @param serializedPresentation
   * @param validateJsonLd
   * @return VerifiablePresentation
   * @throws InvalidJsonLdException
   */
  VerifiablePresentation deserializePresentation(
      SerializedVerifiablePresentation serializedPresentation, boolean validateJsonLd)
      throws InvalidJsonLdException;

  /**
   * Deserialize a presentation and validates the JSON-LD.
   *
   * @param serializedPresentation
   * @return VerifiablePresentation
   * @throws InvalidJsonLdException
   */
  VerifiablePresentation deserializePresentation(
      SerializedVerifiablePresentation serializedPresentation) throws InvalidJsonLdException;
}