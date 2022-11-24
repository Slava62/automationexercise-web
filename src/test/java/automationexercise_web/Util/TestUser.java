package automationexercise_web.Util;

import java.io.IOException;

import automationexercise_web.dto.User;
import automationexercise_web.steps.cucumber.TestContext;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TestUser {
    private static final String BASE_URL = "https://automationexercise.com/api";
    private TestContext context;
    private User testUser;

public TestUser(){
    this.context=new TestContext();
    this.testUser=context.getTestUser();
}
public User createNewUser() throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder()
    .build();
  MediaType mediaType = MediaType.parse("text/plain");
  RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
    .addFormDataPart("name",testUser.getName())
    .addFormDataPart("email",testUser.getEmail())
    .addFormDataPart("password",testUser.getPassword())
    .addFormDataPart("title ",testUser.getTitle())
    .addFormDataPart("birth_date",testUser.getBirthDay())
    .addFormDataPart("birth_month",testUser.getBirthMonth())
    .addFormDataPart("birth_year",testUser.getBirthYear())
    .addFormDataPart("firstname",testUser.getFirstName())
    .addFormDataPart("lastname",testUser.getLastName())
    .addFormDataPart("company",testUser.getCompany())
    .addFormDataPart("address1",testUser.getAddress1())
    .addFormDataPart("address2",testUser.getAddress2())
    .addFormDataPart("country",testUser.getCountry())
    .addFormDataPart("zipcode",testUser.getZipcode())
    .addFormDataPart("state",testUser.getState())
    .addFormDataPart("city",testUser.getCity())
    .addFormDataPart("mobile_number",testUser.getMobile_number())
    .build();
  Request request = new Request.Builder()
    .url(BASE_URL+"/createAccount")
    .method("POST", body)
    .addHeader("Cookie", "csrftoken=RnpWrx9ygNBN8Jp2fPmEKJIEkiltJhVLw1f0zdqiv82Gr6C7DEz44w4qTGpOnIig")
    .build();
  Response response = client.newCall(request).execute();
  if (response.code()==200){ 
    return testUser;
    } else {return null;}
}
public boolean deleteUser(User user) throws IOException {
  OkHttpClient client = new OkHttpClient().newBuilder()
  .build();
MediaType mediaType = MediaType.parse("text/plain");
RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
  .addFormDataPart("email", user.getEmail())
  .addFormDataPart("password",user.getPassword())
  .build();
Request request = new Request.Builder()
  .url("https://automationexercise.com/api/deleteAccount")
  .method("DELETE", body)
  .addHeader("Cookie", "csrftoken=RnpWrx9ygNBN8Jp2fPmEKJIEkiltJhVLw1f0zdqiv82Gr6C7DEz44w4qTGpOnIig")
  .build();
Response response = client.newCall(request).execute();
if (response.code()==200){ 
  return true;
  } else {return false;}
}

}