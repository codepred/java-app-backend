package com.example.cleanrepo.payment_stripe;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.exception.StripeException;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("")
public class ProductsController {

    @Value("${stripe.apikey}")
    private String stripKey;
    @Value("${stripe.your-domain}")
    private String YOUR_DOMAIN;

    @PostMapping("/buy-product/tajski")
    public void buyTajski(final HttpServletResponse response) throws StripeException, IOException {
        Stripe.apiKey = stripKey;
        final var params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPrice("price_1P9roKC4mluOO4qICZwM2bRf")
                        .build())
                .build();
        final var session = Session.create(params);
        response.sendRedirect(session.getUrl());
    }

    @PostMapping("/buy-product/klasyczny")
    public void buyKlasyczny(final HttpServletResponse response) throws StripeException, IOException {
        Stripe.apiKey = stripKey;
        final var params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPrice("price_1PA5tIC4mluOO4qIyiW1YQjc")
                        .build())
                .build();
        final var session = Session.create(params);
        response.sendRedirect(session.getUrl());
    }

    @PostMapping("/buy-product/shiatsu")
    public void buyShiatsu(final HttpServletResponse response) throws StripeException, IOException {
        Stripe.apiKey = stripKey;
        final var params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPrice("price_1PA5tzC4mluOO4qI3PPVXnhI")
                        .build())
                .build();
        final var session = Session.create(params);
        response.sendRedirect(session.getUrl());
    }
}