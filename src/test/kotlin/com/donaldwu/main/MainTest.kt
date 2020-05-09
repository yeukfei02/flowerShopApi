package com.donaldwu.main

import com.donaldwu.common.logger.Logger
import com.donaldwu.main.request.TestRequest
import org.junit.Test
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MainTest {
    private val rootUrl = "https://flower-shop-api.herokuapp.com/api"
    private val createShopUrl = "%s/shop/create-shop".format(rootUrl)
    private val getAllShopUrl = "%s/shop".format(rootUrl)
    private val getShopByIdUrl = "%s/shop/1".format(rootUrl)
    private val updateShopByIdUrl = "%s/shop/1".format(rootUrl)

    private val createFlowerUrl = "%s/flower/create-flower".format(rootUrl)
    private val getAllFlowerUrl = "%s/flower".format(rootUrl)
    private val getFlowerByIdUrl = "%s/flower/1".format(rootUrl)
    private val updateFlowerByIdUrl = "%s/flower/1".format(rootUrl)

    @Test
    fun test_001_createShop() {
        Logger.info("test_001_createShop start")

        val response = TestRequest.createShop(createShopUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_002_getAllShop() {
        Logger.info("test_002_getAllShop start")

        val response = TestRequest.getAllShop(getAllShopUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_003_getShopById() {
        Logger.info("test_003_getShopById start")

        val response = TestRequest.getShopById(getShopByIdUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_004_updateShopById() {
        Logger.info("test_004_updateShopById start")

        val response = TestRequest.updateShopById(updateShopByIdUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_005_createFlower() {
        Logger.info("test_005_createFlower start")

        val response = TestRequest.createFlower(createFlowerUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_006_getAllShop() {
        Logger.info("test_006_getAllShop start")

        val response = TestRequest.getAllFlower(getAllFlowerUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_007_getFlowerById() {
        Logger.info("test_007_getFlowerById start")

        val response = TestRequest.getFlowerById(getFlowerByIdUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_008_updateFlowerById() {
        Logger.info("test_008_updateFlowerById start")

        val response = TestRequest.updateFlowerById(updateFlowerByIdUrl)
        Logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }
}