package com.albertodumonttdev.pmanager.infrastructure.controller;

/**
 * Utility class that holds constant values used in REST controller mappings.
 *
 * Purpose:
 * - Centralizes the definition of endpoint paths to ensure consistency and reusability across the application.
 * - Avoids hardcoding strings like "/projects" in multiple places, making the code easier to maintain.
 *
 * Design notes:
 * - Declared as final to prevent inheritance.
 * - Has a private constructor to prevent instantiation (utility class pattern).
 * - Commonly used in controllers to reference endpoint paths in a centralized way.
 */


public final class RestConstants {

    public static final String PATH_PROJECTS = "/projects";

    private RestConstants () {}
}
