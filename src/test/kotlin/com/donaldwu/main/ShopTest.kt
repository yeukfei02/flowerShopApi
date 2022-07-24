package com.donaldwu.main

import com.donaldwu.main.request.Request
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import org.slf4j.LoggerFactory

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ShopTest {
    private val logger = LoggerFactory.getLogger(ShopTest::class.java)

    private val rootUrl = "https://flower-shop-api.herokuapp.com/api"
    private val createShopUrl = "%s/shop/create-shop".format(rootUrl)
    private val getAllShopUrl = "%s/shop".format(rootUrl)
    private val getShopByIdUrl = "%s/shop/1".format(rootUrl)
    private val updateShopByIdUrl = "%s/shop/1".format(rootUrl)

    @Test
    fun test_001_createShop() {
        logger.info("test_001_createShop start")

        val response = Request.createShop(createShopUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_002_getAllShop() {
        logger.info("test_002_getAllShop start")

        val response = Request.getAllShop(getAllShopUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_003_getShopById() {
        logger.info("test_003_getShopById start")

        val response = Request.getShopById(getShopByIdUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_004_updateShopById() {
        logger.info("test_004_updateShopById start")

        val response = Request.updateShopById(updateShopByIdUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }
}