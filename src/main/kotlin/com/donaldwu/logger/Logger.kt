package com.donaldwu.logger

import org.slf4j.LoggerFactory

class Logger {
    companion object {
        private val logger = LoggerFactory.getLogger(Logger::class.java)

        fun info(message: String) {
            logger.info(message)
        }

//        fun debug(message: String) {
//            logger.debug(message)
//        }
//
//        fun warn(message: String) {
//            logger.warn(message)
//        }
//
//        fun error(message: String) {
//            logger.error(message)
//        }
    }
}