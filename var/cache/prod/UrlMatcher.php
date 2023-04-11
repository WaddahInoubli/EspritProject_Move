<?php

/**
 * This file has been auto-generated
 * by the Symfony Routing Component.
 */

return [
    false, // $matchHost
    [ // $staticRoutes
        '/admin' => [[['_route' => 'back_template', '_controller' => 'App\\Controller\\BackTemplateController::index'], null, null, null, true, false, null]],
        '/' => [[['_route' => 'home', '_controller' => 'App\\Controller\\HomeController::index'], null, null, null, false, false, null]],
        '/inscription' => [[['_route' => 'inscription', '_controller' => 'App\\Controller\\HomeController::inscription'], null, null, null, false, false, null]],
        '/login' => [[['_route' => 'app_login', '_controller' => 'App\\Controller\\LoginController::login'], null, null, null, false, false, null]],
        '/logout' => [[['_route' => 'app_logout', '_controller' => 'App\\Controller\\LoginController::logout'], null, null, null, false, false, null]],
        '/forget-password' => [[['_route' => 'forget_password', '_controller' => 'App\\Controller\\LoginController::forgetPassword'], null, null, null, false, false, null]],
        '/admin/users' => [[['_route' => 'back_users', '_controller' => 'App\\Controller\\UserController::publicitys'], null, null, null, true, false, null]],
        '/admin/users/form' => [[['_route' => 'back_users_form', '_controller' => 'App\\Controller\\UserController::newUser'], null, null, null, false, false, null]],
    ],
    [ // $regexpList
        0 => '{^(?'
                .'|/reset_password/([^/]++)(*:31)'
                .'|/admin/users/(?'
                    .'|form/([^/]++)(*:67)'
                    .'|delete/([^/]++)(*:89)'
                .')'
            .')/?$}sD',
    ],
    [ // $dynamicRoutes
        31 => [[['_route' => 'app_reset_password', '_controller' => 'App\\Controller\\LoginController::resetPassword'], ['token'], null, null, false, true, null]],
        67 => [[['_route' => 'back_users_form_edit', '_controller' => 'App\\Controller\\UserController::editUser'], ['id'], null, null, false, true, null]],
        89 => [
            [['_route' => 'back_users_delete', '_controller' => 'App\\Controller\\UserController::deleteUser'], ['id'], null, null, false, true, null],
            [null, null, null, null, false, false, 0],
        ],
    ],
    null, // $checkCondition
];
