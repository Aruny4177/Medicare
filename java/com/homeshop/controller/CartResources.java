package com.homeshop.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.homeshop.dao.CartDao;
import com.homeshop.dao.CartItemDao;
import com.homeshop.dao.ProductDAO;
import com.homeshop.dao.UserDAO;
import com.homeshop.model.Cart;
import com.homeshop.model.CartItem;
import com.homeshop.model.Product;
import com.homeshop.model.User;


@Controller
@RequestMapping("/customer/rest/cart")
public class CartResources {

    @Autowired
    CartItemDao cartitemdao;

    @Autowired
  ProductDAO productdao;
    @Autowired
   UserDAO user;

    @Autowired
   CartDao cartdao;

    @RequestMapping("/{cartId}")
    public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId){
        return cartdao.getCartById(cartId);
    }
Cart cart;
    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "productId") int productId, Principal principal){
        User customer = user.getCustomerByUsername(principal.getName());
        Cart cart = customer.getCart();
        Product product = productdao.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        	// check if d cart alread has a item if so increment the quantity
        for (int i=0; i < cartItems.size(); i++){
            if(product.getProductId() == cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartitemdao.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartitemdao.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId){
        CartItem cartItem =cartitemdao.getCartItemByProductId(productId);
        cartitemdao.removeCartItem(cartItem);

    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") int cartId){
        Cart cart = cartdao.getCartById(cartId);
        cartitemdao.removeAllCartItems(cart);
    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
//    public void handleClientErrors (Exception ex){
//
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
//    public void handleServerErrors (Exception ex){
//
//    }
    @RequestMapping("/StartFlow")
	public String pageFlow() {
		
		
		return "redirect:/memberShip";
	}
	
	public Cart initFlow(){
		//System.out.println(product);
		return cart;
	}
} // The End of Class;
