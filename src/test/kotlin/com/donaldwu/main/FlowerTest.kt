package com.donaldwu.main

import com.donaldwu.main.request.Request
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import org.slf4j.LoggerFactory

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FlowerTest {
    private val logger = LoggerFactory.getLogger(ShopTest::class.java)

    private val rootUrl = "https://flower-shop-api.herokuapp.com/api"

    private val createFlowerUrl = "%s/flower/create-flower".format(rootUrl)
    private val getAllFlowerUrl = "%s/flower".format(rootUrl)
    private val getFlowerByIdUrl = "%s/flower/1".format(rootUrl)
    private val updateFlowerByIdUrl = "%s/flower/1".format(rootUrl)

    @Test
    fun test_001_createFlower() {
        logger.info("test_001_createFlower start")

        val response = Request.createFlower(createFlowerUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_002_getAllShop() {
        logger.info("test_002_getAllShop start")

        val response = Request.getAllFlower(getAllFlowerUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_003_getFlowerById() {
        logger.info("test_003_getFlowerById start")

        val response = Request.getFlowerById(getFlowerByIdUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }

    @Test
    fun test_004_updateFlowerById() {
        logger.info("test_004_updateFlowerById start")

        val response = Request.updateFlowerById(updateFlowerByIdUrl)
        logger.info("response = $response")

        Assert.assertTrue(response != null && response.isNotEmpty())
    }
}