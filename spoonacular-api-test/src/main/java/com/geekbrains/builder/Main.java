package com.geekbrains.builder;
import api.request.AddToShoppingListRequest;
import api.response.ApiSearchResults;
import api.request.ApiUserConnectRequest;
import api.response.ApiUserConnectResult;
import api.SpoonacularService;
import api.response.shoppinglist.ShoppingListResponse;


public class Main {


    public static void main(String[] args) {

//        User user = User.builder()
//                .setName("Ivan")
//                .setSurname("Ivanov")
//                .setAddress("Address")
//                .setEmail("123@ya.ru")
//                .build();
//        // DSL - domain specific language
//        RequestSpecification requestSpecification =
//                new RequestSpecBuilder()
//                        .build();


        SpoonacularService spoonacularService = new SpoonacularService();
        ApiSearchResults recipes = spoonacularService.findRecipes("Bread", 3);
        System.out.println(recipes);


        ApiUserConnectResult user = spoonacularService.connect(new ApiUserConnectRequest(
                "username",
                "firstname",
                "lastname",
                "email@gmail.com"));
        System.out.println(user);


        ShoppingListResponse shopList = spoonacularService.generate(
                "orville41", 2000-12-12, 2000-12-12,
                "3e633e8b71919a216e114cedfed16137cc788464");
        System.out.println(shopList);


        ShoppingListResponse addProduct = spoonacularService.addItem(
                new AddToShoppingListRequest("1kg apple pie", "pie", true),
                "3e633e8b71919a216e114cedfed16137cc788464", "orville41");
        System.out.println(addProduct);


        ShoppingListResponse deleteProduct = spoonacularService.deleteItem(
                "3e633e8b71919a216e114cedfed16137cc788464", "orville41", 1301765);
        System.out.println(deleteProduct);
    }
}