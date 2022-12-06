package com.buidit.BuildItBack.restresource;

import com.buidit.BuildItBack.model.*;
import com.buidit.BuildItBack.service.*;
import org.aspectj.bridge.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminRestResouce {
    private final UserService userService;
    private  final UserDetailService userDetailService;
    private final BrandService brandService;
    private  final BuildService buildService;
    private final CartService cartService;
    private final CategoryService categoryService;
    private final FactorService factorService;
    private final ProductService productService;
    public AdminRestResouce(UserService userService, UserDetailService userDetailService, BrandService brandService, BuildService buildService, CartService cartService, CategoryService categoryService, FactorService factorService, ProductService productService) {
        this.userService = userService;
        this.userDetailService = userDetailService;
        this.brandService = brandService;
        this.buildService = buildService;
        this.cartService = cartService;
        this.categoryService = categoryService;
        this.factorService = factorService;
        this.productService = productService;
    }


    //---------------------------------------------User Routes------------------------------------------------
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/adminAuth")
    public ResponseEntity<String> userIsFound(User user){
        String message = userService.findUser(user);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @GetMapping("/find/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
        User users = userService.findUserById(userId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User user1 = userService.addUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User user1 = userService.updateUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //--------------------------------------------UserDetail Routes------------------------------------------------
    @GetMapping("/allUserDetails")
    public ResponseEntity<List<UserDetail>> getAllUserDetails(){
        List<UserDetail> userDetails = userDetailService.getAllUserDetails();
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @GetMapping("/find/{userDetailId}")
    public ResponseEntity<UserDetail> getUserDetailsById(@PathVariable("userDetailId") Integer userDetailId){
        UserDetail userDetails = userDetailService.findUserDetailById(userDetailId);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @PostMapping("/addUserDetails")
    public ResponseEntity<UserDetail> addUser(@RequestBody UserDetail userDetail){
        UserDetail userDetail1 = userDetailService.addUserDetail(userDetail);
        return new ResponseEntity<>(userDetail1, HttpStatus.OK);
    }

    @PutMapping("/updateUserDetails")
    public ResponseEntity<UserDetail> updateUser(@RequestBody UserDetail userDetail){
        UserDetail userDetail1 = userDetailService.updateUserDetail(userDetail);
        return new ResponseEntity<>(userDetail1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserDetails/{userDetailId}")
    public ResponseEntity<?> deleteUserDetail(@PathVariable("userDetailId") Integer userDetailId){
        userDetailService.deleteUserDetail(userDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<UserDetail> getUserDetailsByUserId(@PathVariable("userId") Integer userId){
        UserDetail userDetail = userDetailService.findByUserId(userId);
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }

    //--------------------------------------------Brands----------------------------------------------------------
    @GetMapping("/allBrands")
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> brands = brandService.getAllBrands();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @GetMapping("/findBrand/{brandId}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("brandId") Integer brandId){
        Brand brand = brandService.findByBrandId(brandId);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping("/addBrand")
    public ResponseEntity<Brand> addBrand(@RequestBody Brand brand){
        Brand brand1 = brandService.addBrand(brand);
        return new ResponseEntity<>(brand1, HttpStatus.OK);
    }

    @PutMapping("/updateBrand")
    public ResponseEntity<Brand> updateUser(@RequestBody Brand brand){
        Brand brand1 = brandService.updateBrand(brand);
        return new ResponseEntity<>(brand1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBrand/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable("brandId") Integer brandId){
        brandService.deleteBrand(brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByName/{brandName}")
    public ResponseEntity<Brand> getBrandByName(@PathVariable("brandName") String brandName){
        Brand brand = brandService.searchByBrandName(brandName);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    //-------------------------------------------Build------------------------------------------------------------
    @GetMapping("/allBuilds")
    public ResponseEntity<List<Build>> getAllBuilds(){
        List<Build> builds = buildService.getAllBuild();
        return new ResponseEntity<>(builds, HttpStatus.OK);
    }

    @GetMapping("/find/{buildId}")
    public ResponseEntity<Build> getByBuildId(@PathVariable("buildId") Integer buildId){
        Build build = buildService.findByBuildId(buildId);
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

    @PostMapping("/addBuild")
    public ResponseEntity<Build> addBuild(@RequestBody Build build){
        Build build1 = buildService.addBuild(build);
        return new ResponseEntity<>(build1, HttpStatus.OK);
    }

    @PutMapping("/updateBuild")
    public ResponseEntity<Build> updateBuild(@RequestBody Build build){
        Build build1 = buildService.updateBuild(build);
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBuild/{buildId}")
    public ResponseEntity<?> deleteBuild(@PathVariable("buildId") Integer buildId){
        buildService.deleteBuild(buildId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findBuildByUserId/{userId}")
    public ResponseEntity<Build> getBuildByUserId(@PathVariable("userId") Integer userId){
        Build build = buildService.findByUserId(userId);
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

    //-------------------------------------------------Cart------------------------------------------------------------------
    @GetMapping("/allCart")
    public ResponseEntity<List<Cart>> getAllCart(){
        List<Cart> cart = cartService.getCart();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @PostMapping("/addCart")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
        Cart cart1 = cartService.addCart(cart);
        return new ResponseEntity<>(cart1, HttpStatus.OK);
    }

    @PutMapping("/updateCart")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
        Cart cart1 = cartService.updateCart(cart);
        return new ResponseEntity<>(cart1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCart/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable("cartId") Integer cartId){
        cartService.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteCartByUserId/{userId}")
    public ResponseEntity<?> deleteCartByUserId(@PathVariable("userId") Integer userId){
        cartService.deleteCartByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/cartByUserId/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable("userId")Integer userId){
        Cart cart = cartService.findCartByUserId(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @GetMapping("/cartByProductId/{productId}")
    public ResponseEntity<Cart> getCartByProductId(@PathVariable("productId")Integer productId){
        Cart cart = cartService.findCartByProductId(productId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @GetMapping("/cartById/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable("cartId")Integer cartId){
        Cart cart = cartService.findCartById(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    //----------------------------------------------------Category--------------------------------------------------

    @GetMapping("/allCategory")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = categoryService.getCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = categoryService.addCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }
    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category category1 = categoryService.updateCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId){
        categoryService.findByCategoryId(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/categoryByName/{categoryName}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable("categorName") String categoryName){
        Category category = categoryService.findByCategoryName(categoryName);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @GetMapping("/categoryByBrandId/{brandId}")
    public ResponseEntity<Category> getCategoryByBrandId(@PathVariable("brandId") Integer brandId){
        Category category = categoryService.findByBrandId(brandId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

//----------------------------------------------------Factor--------------------------------------------------
    @GetMapping("/allFactors")
    public ResponseEntity<List<Factor>> getAllFactors(){
        List<Factor> factors = factorService.getFactor();
        return new ResponseEntity<>(factors, HttpStatus.OK);
    }
    @PostMapping("/addFactor")
    public ResponseEntity<Factor> addFactor(@RequestBody Factor factor){
        Factor factor1 = factorService.addFactor(factor);
        return new ResponseEntity<>(factor1, HttpStatus.OK);
    }
    @PutMapping("/updateFactor")
    public ResponseEntity<Factor> updateFactor(@RequestBody Factor factor){
        Factor factor1 = factorService.updateFactor(factor);
        return new ResponseEntity<>(factor1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteFactor/{factorId}")
    public ResponseEntity<?> deleteFactor(@PathVariable("factorId") Integer factorId){
        factorService.deleteFactor(factorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/factorByName/{factorName}")
    public ResponseEntity<Factor> getFactorByName(@PathVariable("factorName") String factorName){
        Factor factor = factorService.getFactorByName(factorName);
        return new ResponseEntity<>(factor, HttpStatus.OK);
    }
    @GetMapping("/factorById/{factorId}")
    public ResponseEntity<Factor> getFactorByFactorId(@PathVariable("factorId") Integer factorId){
        Factor factor = factorService.findByFactorId(factorId);
        return new ResponseEntity<>(factor, HttpStatus.OK);
    }
//-------------------------------------------------------Product--------------------------------------------------
    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
    List<Product> products = productService.getProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
}
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addFactor(@RequestBody Product product){
        Product product1 = productService.addProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1 = productService.updateProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getProductByName/{productName}")
    public ResponseEntity<Product> getProductByName(@PathVariable("productName") String productName){
        Product product = productService.getProductByName(productName);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/getProductByModelNumber/{modelNumber}")
    public ResponseEntity<Product> getProductByModelNumber(@PathVariable("modelNumber") String modelNumber){
        Product product = productService.getProductByModelNo(modelNumber);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/getProductByCategoryId/{categoryId}")
    public ResponseEntity<Product> getProductByModelNumber(@PathVariable("categoryId") Integer categoryId){
        Product product = productService.getProductByCategoryId(categoryId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
