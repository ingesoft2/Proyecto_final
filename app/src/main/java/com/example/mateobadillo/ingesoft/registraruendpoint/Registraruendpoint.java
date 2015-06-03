/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-03-26 20:30:19 UTC)
 * on 2015-05-29 at 14:09:59 UTC 
 * Modify at your own risk.
 */

package com.example.mateobadillo.ingesoft.registraruendpoint;

import com.example.mateobadillo.ingesoft.registraruendpoint.model.CollectionResponseRegistrarU;
import com.example.mateobadillo.ingesoft.registraruendpoint.model.RegistrarU;

/**
 * Service definition for Registraruendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link RegistraruendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Registraruendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the registraruendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */


  public static final String DEFAULT_ROOT_URL = "https://omega-episode-92402.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "com/example/mateobadillo/ingesoft/registraruendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Registraruendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Registraruendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getRegistrarU".
   *
   * This request holds the parameters needed by the registraruendpoint server.  After setting any
   * optional parameters, call the {@link GetRegistrarU#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetRegistrarU getRegistrarU(Long id) throws java.io.IOException {
    GetRegistrarU result = new GetRegistrarU(id);
    initialize(result);
    return result;
  }

  public class GetRegistrarU extends RegistraruendpointRequest<RegistrarU> {

    private static final String REST_PATH = "registraru/{id}";

    /**
     * Create a request for the method "getRegistrarU".
     *
     * This request holds the parameters needed by the the registraruendpoint server.  After setting
     * any optional parameters, call the {@link GetRegistrarU#execute()} method to invoke the remote
     * operation. <p> {@link GetRegistrarU#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetRegistrarU(Long id) {
      super(Registraruendpoint.this, "GET", REST_PATH, null, RegistrarU.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetRegistrarU setAlt(String alt) {
      return (GetRegistrarU) super.setAlt(alt);
    }

    @Override
    public GetRegistrarU setFields(String fields) {
      return (GetRegistrarU) super.setFields(fields);
    }

    @Override
    public GetRegistrarU setKey(String key) {
      return (GetRegistrarU) super.setKey(key);
    }

    @Override
    public GetRegistrarU setOauthToken(String oauthToken) {
      return (GetRegistrarU) super.setOauthToken(oauthToken);
    }

    @Override
    public GetRegistrarU setPrettyPrint(Boolean prettyPrint) {
      return (GetRegistrarU) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetRegistrarU setQuotaUser(String quotaUser) {
      return (GetRegistrarU) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetRegistrarU setUserIp(String userIp) {
      return (GetRegistrarU) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private Long id;

    /**

     */
    public Long getId() {
      return id;
    }

    public GetRegistrarU setId(Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetRegistrarU set(String parameterName, Object value) {
      return (GetRegistrarU) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertRegistrarU".
   *
   * This request holds the parameters needed by the registraruendpoint server.  After setting any
   * optional parameters, call the {@link InsertRegistrarU#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.example.mateobadillo.ingesoft.registraruendpoint.model.RegistrarU}
   * @return the request
   */
  public InsertRegistrarU insertRegistrarU(RegistrarU content) throws java.io.IOException {
    InsertRegistrarU result = new InsertRegistrarU(content);
    initialize(result);
    return result;
  }

  public class InsertRegistrarU extends RegistraruendpointRequest<RegistrarU> {

    private static final String REST_PATH = "registraru";

    /**
     * Create a request for the method "insertRegistrarU".
     *
     * This request holds the parameters needed by the the registraruendpoint server.  After setting
     * any optional parameters, call the {@link InsertRegistrarU#execute()} method to invoke the
     * remote operation. <p> {@link InsertRegistrarU#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.example.mateobadillo.ingesoft.registraruendpoint.model.RegistrarU}
     * @since 1.13
     */
    protected InsertRegistrarU(RegistrarU content) {
      super(Registraruendpoint.this, "POST", REST_PATH, content, RegistrarU.class);
    }

    @Override
    public InsertRegistrarU setAlt(String alt) {
      return (InsertRegistrarU) super.setAlt(alt);
    }

    @Override
    public InsertRegistrarU setFields(String fields) {
      return (InsertRegistrarU) super.setFields(fields);
    }

    @Override
    public InsertRegistrarU setKey(String key) {
      return (InsertRegistrarU) super.setKey(key);
    }

    @Override
    public InsertRegistrarU setOauthToken(String oauthToken) {
      return (InsertRegistrarU) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertRegistrarU setPrettyPrint(Boolean prettyPrint) {
      return (InsertRegistrarU) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertRegistrarU setQuotaUser(String quotaUser) {
      return (InsertRegistrarU) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertRegistrarU setUserIp(String userIp) {
      return (InsertRegistrarU) super.setUserIp(userIp);
    }

    @Override
    public InsertRegistrarU set(String parameterName, Object value) {
      return (InsertRegistrarU) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listRegistrarU".
   *
   * This request holds the parameters needed by the registraruendpoint server.  After setting any
   * optional parameters, call the {@link ListRegistrarU#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListRegistrarU listRegistrarU() throws java.io.IOException {
    ListRegistrarU result = new ListRegistrarU();
    initialize(result);
    return result;
  }

  public class ListRegistrarU extends RegistraruendpointRequest<CollectionResponseRegistrarU> {

    private static final String REST_PATH = "registraru";

    /**
     * Create a request for the method "listRegistrarU".
     *
     * This request holds the parameters needed by the the registraruendpoint server.  After setting
     * any optional parameters, call the {@link ListRegistrarU#execute()} method to invoke the remote
     * operation. <p> {@link ListRegistrarU#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListRegistrarU() {
      super(Registraruendpoint.this, "GET", REST_PATH, null, CollectionResponseRegistrarU.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListRegistrarU setAlt(String alt) {
      return (ListRegistrarU) super.setAlt(alt);
    }

    @Override
    public ListRegistrarU setFields(String fields) {
      return (ListRegistrarU) super.setFields(fields);
    }

    @Override
    public ListRegistrarU setKey(String key) {
      return (ListRegistrarU) super.setKey(key);
    }

    @Override
    public ListRegistrarU setOauthToken(String oauthToken) {
      return (ListRegistrarU) super.setOauthToken(oauthToken);
    }

    @Override
    public ListRegistrarU setPrettyPrint(Boolean prettyPrint) {
      return (ListRegistrarU) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListRegistrarU setQuotaUser(String quotaUser) {
      return (ListRegistrarU) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListRegistrarU setUserIp(String userIp) {
      return (ListRegistrarU) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private String cursor;

    /**

     */
    public String getCursor() {
      return cursor;
    }

    public ListRegistrarU setCursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private Integer limit;

    /**

     */
    public Integer getLimit() {
      return limit;
    }

    public ListRegistrarU setLimit(Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListRegistrarU set(String parameterName, Object value) {
      return (ListRegistrarU) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeRegistrarU".
   *
   * This request holds the parameters needed by the registraruendpoint server.  After setting any
   * optional parameters, call the {@link RemoveRegistrarU#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveRegistrarU removeRegistrarU(Long id) throws java.io.IOException {
    RemoveRegistrarU result = new RemoveRegistrarU(id);
    initialize(result);
    return result;
  }

  public class RemoveRegistrarU extends RegistraruendpointRequest<Void> {

    private static final String REST_PATH = "registraru/{id}";

    /**
     * Create a request for the method "removeRegistrarU".
     *
     * This request holds the parameters needed by the the registraruendpoint server.  After setting
     * any optional parameters, call the {@link RemoveRegistrarU#execute()} method to invoke the
     * remote operation. <p> {@link RemoveRegistrarU#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveRegistrarU(Long id) {
      super(Registraruendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveRegistrarU setAlt(String alt) {
      return (RemoveRegistrarU) super.setAlt(alt);
    }

    @Override
    public RemoveRegistrarU setFields(String fields) {
      return (RemoveRegistrarU) super.setFields(fields);
    }

    @Override
    public RemoveRegistrarU setKey(String key) {
      return (RemoveRegistrarU) super.setKey(key);
    }

    @Override
    public RemoveRegistrarU setOauthToken(String oauthToken) {
      return (RemoveRegistrarU) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveRegistrarU setPrettyPrint(Boolean prettyPrint) {
      return (RemoveRegistrarU) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveRegistrarU setQuotaUser(String quotaUser) {
      return (RemoveRegistrarU) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveRegistrarU setUserIp(String userIp) {
      return (RemoveRegistrarU) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private Long id;

    /**

     */
    public Long getId() {
      return id;
    }

    public RemoveRegistrarU setId(Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveRegistrarU set(String parameterName, Object value) {
      return (RemoveRegistrarU) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateRegistrarU".
   *
   * This request holds the parameters needed by the registraruendpoint server.  After setting any
   * optional parameters, call the {@link UpdateRegistrarU#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.example.mateobadillo.ingesoft.registraruendpoint.model.RegistrarU}
   * @return the request
   */
  public UpdateRegistrarU updateRegistrarU(RegistrarU content) throws java.io.IOException {
    UpdateRegistrarU result = new UpdateRegistrarU(content);
    initialize(result);
    return result;
  }

  public class UpdateRegistrarU extends RegistraruendpointRequest<RegistrarU> {

    private static final String REST_PATH = "registraru";

    /**
     * Create a request for the method "updateRegistrarU".
     *
     * This request holds the parameters needed by the the registraruendpoint server.  After setting
     * any optional parameters, call the {@link UpdateRegistrarU#execute()} method to invoke the
     * remote operation. <p> {@link UpdateRegistrarU#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.example.mateobadillo.ingesoft.registraruendpoint.model.RegistrarU}
     * @since 1.13
     */
    protected UpdateRegistrarU(RegistrarU content) {
      super(Registraruendpoint.this, "PUT", REST_PATH, content, RegistrarU.class);
    }

    @Override
    public UpdateRegistrarU setAlt(String alt) {
      return (UpdateRegistrarU) super.setAlt(alt);
    }

    @Override
    public UpdateRegistrarU setFields(String fields) {
      return (UpdateRegistrarU) super.setFields(fields);
    }

    @Override
    public UpdateRegistrarU setKey(String key) {
      return (UpdateRegistrarU) super.setKey(key);
    }

    @Override
    public UpdateRegistrarU setOauthToken(String oauthToken) {
      return (UpdateRegistrarU) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateRegistrarU setPrettyPrint(Boolean prettyPrint) {
      return (UpdateRegistrarU) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateRegistrarU setQuotaUser(String quotaUser) {
      return (UpdateRegistrarU) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateRegistrarU setUserIp(String userIp) {
      return (UpdateRegistrarU) super.setUserIp(userIp);
    }

    @Override
    public UpdateRegistrarU set(String parameterName, Object value) {
      return (UpdateRegistrarU) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Registraruendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Registraruendpoint}. */
    @Override
    public Registraruendpoint build() {
      return new Registraruendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link RegistraruendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setRegistraruendpointRequestInitializer(
        RegistraruendpointRequestInitializer registraruendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(registraruendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
