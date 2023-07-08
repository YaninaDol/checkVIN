package com.example.accessingdatarest.Controller;

import com.example.accessingdatarest.Model.Package;
import com.example.accessingdatarest.Model.User;
import com.example.accessingdatarest.Repositories.CarRepository;
import com.example.accessingdatarest.Model.Car;
import com.example.accessingdatarest.Repositories.PackageRepository;
import com.example.accessingdatarest.Repositories.UserRepository;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Controller // This means that this class is a Controller
@RequestMapping(path="/car")

public class CarController {
    @Autowired
private CarRepository _carRepository;
    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private PackageRepository _packageRepository;

    @GetMapping(path="/api")
    public @ResponseBody String api(@RequestParam String  VIN,@RequestParam int  user_id) throws IOException, InterruptedException {

        if(_userRepository.existsById(user_id)) {
              //  User user=_userRepository.findById(user_id).get();

//                if((user.getCount()+1)<=_packageRepository.findById(user.getPackage_id()).get().getMax())
//                {

                    //api search
            //  This returns a JSON or XML with the users
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://vindecoder.p.rapidapi.com/decode_vin?vin="+VIN))
//                .header("X-RapidAPI-Key", "c437db51f7msha1da5617664decbp1d06d3jsn9110935b1618")
//                .header("X-RapidAPI-Host", "vindecoder.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//
//        HttpRequest request2 = HttpRequest.newBuilder()
//                .uri(URI.create("https://vindecoder.p.rapidapi.com/salvage_check?vin="+VIN))
//                .header("X-RapidAPI-Key", "c437db51f7msha1da5617664decbp1d06d3jsn9110935b1618")
//                .header("X-RapidAPI-Host", "vindecoder.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
//      //  System.out.println(response.body());
//
//        String answer="["+response.body()+"]";
//
//        JSONArray array = new JSONArray(answer);
//        JSONObject object = array.getJSONObject(0);
//       // System.out.println(object);
//        JSONArray array2 =new JSONArray("["+object.get("specification").toString()+"]");
////        for(int i=0; i < array2.length(); i++) {
////            JSONObject object2 = array2.getJSONObject(i);
////            System.out.println(object2.getString("vin"));
////            System.out.println(object2.getString("year"));
////        }
//        Car _car=new Car(array2.getJSONObject(0).getString("vin"),array2.getJSONObject(0).getString("make"),array2.getJSONObject(0).getString("model"),array2.getJSONObject(0).getString("year"),array2.getJSONObject(0).getString("trim_level"),array2.getJSONObject(0).getString("engine"),array2.getJSONObject(0).getString("style"),array2.getJSONObject(0).getString("made_in"),array2.getJSONObject(0).getString("anti_brake_system"),array2.getJSONObject(0).get("tank_size").toString(),array2.getJSONObject(0).getString("overall_height"),array2.getJSONObject(0).getString("overall_length"),array2.getJSONObject(0).getString("overall_width"),array2.getJSONObject(0).getString("standard_seating"),array2.getJSONObject(0).getString("highway_mileage"),array2.getJSONObject(0).getString("city_mileage"));
//        _carRepository.save(_car);
                  //  user.setCount(user.getCount()+1);
                  //  _userRepository.save(user);
            //  return new Gson().toJson(_car);

                //

//
//                }
//
//                else return "Update your traffic package!";


            Car _car = _carRepository.findById(1).get();

            return new Gson().toJson(_car);
        }

        else return "User not exist!";
    }

    @GetMapping(path="/getImg")
    public @ResponseBody Iterable<Object> getImg(@RequestParam String  VIN) throws IOException, InterruptedException {



        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://ucars.pro/presearch?search="+VIN))
                .header("Authorization", "Bearer eyJpdiI6IkV2bFFKQlk1c0VtN3RwNHFmU090WWc9PSIsInZhbHVlIjoiLytUMVYzUGZtMVp6TjVyN2FHWHJkMTdzaFM1QjBIdkNQbzdBaDFTVThxYXFuRzVMcnZEWTN4emk0RkI1MjRLbEo1dWYyeTB2WHNsVEs0dXl4SDBSUCtmQkRGQ2s2cjJpMG5JVGE4dU5MTStjQVhEQ29panZqQ2daRmdib3RuZFciLCJtYWMiOiIzNzI1ZjcwYzkzZjUxZTg0ZjIyMDU2ZTcyMjcwNDcwNGNlZWEyZWU0NzZiYzNkMGZjYjM0NjllODUyN2ZmNzExIiwidGFnIjoiIn0%3D")
                .header("Cookie", "XSRF-TOKEN=eyJpdiI6IjVvTUdVd1ZvbjI3dVMzSHpHVTVwcEE9PSIsInZhbHVlIjoiL25hbzk2dzBzRm82dTV1NDh6VW05cXVGUkNYam5CQkU1RHlTRDNIYmh3eHVyWFZIakhzdlNDTXZ5R2Z6cnJVZEVFbmZ3bnZFeXNNVGVlRTNnYlZ1ai9YYjF2Um5IU2lEVG81UVZHU21iamg0TE5ieEhpQkdCT0ZnNDNvMEljdUIiLCJtYWMiOiIxYmFhM2EyODgwZTc0NmQwMzc2MzE0NmRjNTE1OWU4YzE0MjE2YjNkMGQwZGVmYmQ5MzE0Y2JkNjFjNjQzY2I2IiwidGFnIjoiIn0%3D; __cf_bm=P8ChpK4Zqoz18vy6.Uk368d.4woAaTYIE3EEsLtp2sA-1688665588-0-ATuNDappvNroHPhiiVDnMSFmQ9yXRrWhblECpXIRTE2x2f/gPYs0HxHz195a6Zrntw==; ucars_session=eyJpdiI6ImhrWHFBa1ZCbTgxamI0U1BxTEszWUE9PSIsInZhbHVlIjoiaWJKdGllRklJRFJUVEFUYlNDVkh1TnVCeVpEMU9NcytxeW4vcFlGeStpMG5ZYkl3MHdZZVVGcEhtMXB4cUU2M3lYeVBHSkJNZEtQR3VHV25OOWpEMnVCQ2RJZGNvRml3c3BlemQ3cjNHQ0NDWk5iN3dPZW9zZzZuNG51L0lXaXgiLCJtYWMiOiJiNmZlOWY2MDQ0MDdiYTVjZTBlOTkzZjQzM2RlYTNkYjE0NTg0Y2M2MDUxZGUzODc5NDVjYTg5ZGNhNWMxZjZiIiwidGFnIjoiIn0%3D")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
        String[] arrOfStr = response2.body().split("\"",7);
        System.out.println(arrOfStr[5]);
        String charsToRemove = "\\";
        String url=new String();
        for (char c : charsToRemove.toCharArray()) {
            url = arrOfStr[5].replace(String.valueOf(c), "");
        }

        System.out.println(url);
        Document document = Jsoup.connect(url).get();
        // document.select("img").forEach(System.out::println);
        Iterable iter=document.select("img");
        ArrayList<Object> images = new ArrayList<Object>();
        for (var item:iter)
        {
            if(item.toString().contains("data-splide-lazy"))
            {
                // System.out.println(item);
                images.add(item);
            }
        }

        return images ;


    }
    @GetMapping(path="/getURL")
    public @ResponseBody String getURL(@RequestParam String  VIN) throws IOException, InterruptedException {



        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://ucars.pro/presearch?search="+VIN))
                .header("Authorization", "Bearer eyJpdiI6IkV2bFFKQlk1c0VtN3RwNHFmU090WWc9PSIsInZhbHVlIjoiLytUMVYzUGZtMVp6TjVyN2FHWHJkMTdzaFM1QjBIdkNQbzdBaDFTVThxYXFuRzVMcnZEWTN4emk0RkI1MjRLbEo1dWYyeTB2WHNsVEs0dXl4SDBSUCtmQkRGQ2s2cjJpMG5JVGE4dU5MTStjQVhEQ29panZqQ2daRmdib3RuZFciLCJtYWMiOiIzNzI1ZjcwYzkzZjUxZTg0ZjIyMDU2ZTcyMjcwNDcwNGNlZWEyZWU0NzZiYzNkMGZjYjM0NjllODUyN2ZmNzExIiwidGFnIjoiIn0%3D")
                .header("Cookie", "XSRF-TOKEN=eyJpdiI6IjVvTUdVd1ZvbjI3dVMzSHpHVTVwcEE9PSIsInZhbHVlIjoiL25hbzk2dzBzRm82dTV1NDh6VW05cXVGUkNYam5CQkU1RHlTRDNIYmh3eHVyWFZIakhzdlNDTXZ5R2Z6cnJVZEVFbmZ3bnZFeXNNVGVlRTNnYlZ1ai9YYjF2Um5IU2lEVG81UVZHU21iamg0TE5ieEhpQkdCT0ZnNDNvMEljdUIiLCJtYWMiOiIxYmFhM2EyODgwZTc0NmQwMzc2MzE0NmRjNTE1OWU4YzE0MjE2YjNkMGQwZGVmYmQ5MzE0Y2JkNjFjNjQzY2I2IiwidGFnIjoiIn0%3D; __cf_bm=P8ChpK4Zqoz18vy6.Uk368d.4woAaTYIE3EEsLtp2sA-1688665588-0-ATuNDappvNroHPhiiVDnMSFmQ9yXRrWhblECpXIRTE2x2f/gPYs0HxHz195a6Zrntw==; ucars_session=eyJpdiI6ImhrWHFBa1ZCbTgxamI0U1BxTEszWUE9PSIsInZhbHVlIjoiaWJKdGllRklJRFJUVEFUYlNDVkh1TnVCeVpEMU9NcytxeW4vcFlGeStpMG5ZYkl3MHdZZVVGcEhtMXB4cUU2M3lYeVBHSkJNZEtQR3VHV25OOWpEMnVCQ2RJZGNvRml3c3BlemQ3cjNHQ0NDWk5iN3dPZW9zZzZuNG51L0lXaXgiLCJtYWMiOiJiNmZlOWY2MDQ0MDdiYTVjZTBlOTkzZjQzM2RlYTNkYjE0NTg0Y2M2MDUxZGUzODc5NDVjYTg5ZGNhNWMxZjZiIiwidGFnIjoiIn0%3D")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
        String[] arrOfStr = response2.body().split("\"",7);
        System.out.println(arrOfStr[5]);
        String charsToRemove = "\\";
        String url=new String();
        for (char c : charsToRemove.toCharArray()) {
            url = arrOfStr[5].replace(String.valueOf(c), "");
        }

        System.out.println(url);
        Document document = Jsoup.connect(url).get();
        // document.select("img").forEach(System.out::println);
        Iterable iter=document.select("img");
        ArrayList<Object> images = new ArrayList<Object>();
        for (var item:iter)
        {
            if(item.toString().contains("data-splide-lazy"))
            {
                // System.out.println(item);
                images.add(item);
            }
        }

        String[] arr = images.get(0).toString().split(":",10);

//        for (String a : arr)
//            System.out.println(a);

        String rem=arr[3].replace("\"","");
        String lot=rem.replace(">","");
        //System.out.println("https://www.copart.com/lot/"+lot);
        return ("https://www.copart.com/lot/"+lot);


    }


}
