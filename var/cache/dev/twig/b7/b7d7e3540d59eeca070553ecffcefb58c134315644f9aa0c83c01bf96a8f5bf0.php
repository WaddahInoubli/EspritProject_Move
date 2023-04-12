<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* base.html.twig */
class __TwigTemplate_cbe3c3a7908a644c82b97e0271ae0f1b5523a60313eca63601232d6ccccf3197 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'stylesheets' => [$this, 'block_stylesheets'],
            'javascripts' => [$this, 'block_javascripts'],
            'header' => [$this, 'block_header'],
            'sidebar' => [$this, 'block_sidebar'],
            'body' => [$this, 'block_body'],
            'footer' => [$this, 'block_footer'],
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "base.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "base.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html>
\t<head>
\t\t<meta charset=\"UTF-8\">
\t\t<title>
\t\t\t";
        // line 6
        $this->displayBlock('title', $context, $blocks);
        // line 8
        echo "\t\t</title>
\t\t";
        // line 9
        $this->displayBlock('stylesheets', $context, $blocks);
        // line 28
        echo "
\t\t";
        // line 29
        $this->displayBlock('javascripts', $context, $blocks);
        // line 43
        echo "\t</head>
\t<body>
\t\t";
        // line 45
        $this->displayBlock('header', $context, $blocks);
        // line 266
        echo "
\t\t";
        // line 267
        $this->displayBlock('sidebar', $context, $blocks);
        // line 321
        echo "
\t\t";
        // line 322
        $this->displayBlock('body', $context, $blocks);
        // line 323
        echo "
\t\t";
        // line 324
        $this->displayBlock('footer', $context, $blocks);
        // line 344
        echo "\t</body>
</html>";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 6
    public function block_title($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        echo "Welcome!
\t\t\t";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 9
    public function block_stylesheets($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 10
        echo "\t\t\t<!-- Google Fonts -->
\t\t\t<link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">
\t\t\t<link
\t\t\thref=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">

\t\t\t<!-- Vendor CSS Files -->
\t\t\t<link href=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/bootstrap/css/bootstrap.min.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
\t\t\t<link href=\"";
        // line 17
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/bootstrap-icons/bootstrap-icons.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
\t\t\t<link href=\"";
        // line 18
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/boxicons/css/boxicons.min.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
\t\t\t<link href=\"";
        // line 19
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/quill/quill.snow.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
\t\t\t<link href=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/quill/quill.bubble.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
\t\t\t<link href=\"";
        // line 21
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/remixicon/remixicon.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
\t\t\t<link
\t\t\thref=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/simple-datatables/style.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">

\t\t\t<!-- Template Main CSS File -->
\t\t\t<link href=\"";
        // line 26
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/css/style.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
\t\t";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 29
    public function block_javascripts($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        // line 30
        echo "\t\t\t<!-- Vendor JS Files -->
\t\t\t<script src=\"";
        // line 31
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/apexcharts/apexcharts.min.js"), "html", null, true);
        echo "\"></script>
\t\t\t<script src=\"";
        // line 32
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/bootstrap/js/bootstrap.bundle.min.js"), "html", null, true);
        echo "\"></script>
\t\t\t<script src=\"";
        // line 33
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/chart.js/chart.min.js"), "html", null, true);
        echo "\"></script>
\t\t\t<script src=\"";
        // line 34
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/echarts/echarts.min.js"), "html", null, true);
        echo "\"></script>
\t\t\t<script src=\"";
        // line 35
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/quill/quill.min.js"), "html", null, true);
        echo "\"></script>
\t\t\t<script src=\"";
        // line 36
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/simple-datatables/simple-datatables.js"), "html", null, true);
        echo "\"></script>
\t\t\t<script src=\"";
        // line 37
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/tinymce/tinymce.min.js"), "html", null, true);
        echo "\"></script>
\t\t\t<script src=\"";
        // line 38
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/vendor/php-email-form/validate.js"), "html", null, true);
        echo "\"></script>

\t\t\t<!-- Template Main JS File -->
\t\t\t<script src=\"";
        // line 41
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/js/main.js"), "html", null, true);
        echo "\"></script>
\t\t";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 45
    public function block_header($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "header"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "header"));

        // line 46
        echo "\t\t\t<!-- ======= Header ======= -->
\t\t\t<header id=\"header\" class=\"header fixed-top d-flex align-items-center\">

\t\t\t\t<div class=\"d-flex align-items-center justify-content-between\">

\t\t\t\t\t<i class=\"bi bi-list toggle-sidebar-btn\"></i>
\t\t\t\t</div>
\t\t\t\t<!-- End Logo -->

\t\t\t\t<div class=\"search-bar\">
\t\t\t\t\t<form class=\"search-form d-flex align-items-center\" method=\"POST\" action=\"#\">
\t\t\t\t\t\t<input type=\"text\" name=\"query\" placeholder=\"Search\" title=\"Enter search keyword\">
\t\t\t\t\t\t<button type=\"submit\" title=\"Search\">
\t\t\t\t\t\t\t<i class=\"bi bi-search\"></i>
\t\t\t\t\t\t</button>
\t\t\t\t\t</form>
\t\t\t\t</div>
\t\t\t\t<!-- End Search Bar -->

\t\t\t\t<nav class=\"header-nav ms-auto\">
\t\t\t\t\t<ul class=\"d-flex align-items-center\">

\t\t\t\t\t\t<li class=\"nav-item d-block d-lg-none\">
\t\t\t\t\t\t\t<a class=\"nav-link nav-icon search-bar-toggle \" href=\"#\">
\t\t\t\t\t\t\t\t<i class=\"bi bi-search\"></i>
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Search Icon-->

\t\t\t\t\t\t<li class=\"nav-item dropdown\">

\t\t\t\t\t\t\t<a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">
\t\t\t\t\t\t\t\t<i class=\"bi bi-bell\"></i>
\t\t\t\t\t\t\t\t<span class=\"badge bg-primary badge-number\">4</span>
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t<!-- End Notification Icon -->

\t\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications\">
\t\t\t\t\t\t\t\t<li class=\"dropdown-header\">
\t\t\t\t\t\t\t\t\tYou have 4 new notifications
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<span class=\"badge rounded-pill bg-primary p-2 ms-2\">View all</span>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-exclamation-circle text-warning\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Lorem Ipsum</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>30 min. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-x-circle text-danger\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Atque rerum nesciunt</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>1 hr. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-check-circle text-success\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Sit rerum fuga</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>2 hrs. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-info-circle text-primary\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Dicta reprehenderit</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>4 hrs. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li class=\"dropdown-footer\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">Show all notifications</a>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t<!-- End Notification Dropdown Items -->

\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Notification Nav -->

\t\t\t\t\t\t<li class=\"nav-item dropdown\">

\t\t\t\t\t\t\t<a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">
\t\t\t\t\t\t\t\t<i class=\"bi bi-chat-left-text\"></i>
\t\t\t\t\t\t\t\t<span class=\"badge bg-success badge-number\">3</span>
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t<!-- End Messages Icon -->

\t\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow messages\">
\t\t\t\t\t\t\t\t<li class=\"dropdown-header\">
\t\t\t\t\t\t\t\t\tYou have 3 new messages
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<span class=\"badge rounded-pill bg-primary p-2 ms-2\">View all</span>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"message-item\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<img src=\"";
        // line 176
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/img/messages-1.jpg"), "html", null, true);
        echo "\" alt=\"\" class=\"rounded-circle\">
\t\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t\t<h4>Maria Hudson</h4>
\t\t\t\t\t\t\t\t\t\t\t<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
\t\t\t\t\t\t\t\t\t\t\t<p>4 hrs. ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"message-item\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<img src=\"";
        // line 190
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/img/messages-2.jpg"), "html", null, true);
        echo "\" alt=\"\" class=\"rounded-circle\">
\t\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t\t<h4>Anna Nelson</h4>
\t\t\t\t\t\t\t\t\t\t\t<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
\t\t\t\t\t\t\t\t\t\t\t<p>6 hrs. ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"message-item\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<img src=\"";
        // line 204
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("admin/img/messages-3.jpg"), "html", null, true);
        echo "\" alt=\"\" class=\"rounded-circle\">
\t\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t\t<h4>David Muldon</h4>
\t\t\t\t\t\t\t\t\t\t\t<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
\t\t\t\t\t\t\t\t\t\t\t<p>8 hrs. ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"dropdown-footer\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">Show all messages</a>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t<!-- End Messages Dropdown Items -->

\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Messages Nav -->

\t\t\t\t\t\t<li
\t\t\t\t\t\t\tclass=\"nav-item dropdown pe-3\">


\t\t\t\t\t\t\t<!-- End Profile Iamge Icon -->

\t\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow profile\">

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t<!-- End Profile Dropdown Items -->
\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Profile Nav -->

\t\t\t\t\t</ul>
\t\t\t\t</nav>
\t\t\t\t<!-- End Icons Navigation -->

\t\t\t</header>
\t\t\t<!-- End Header -->
\t\t";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 267
    public function block_sidebar($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "sidebar"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "sidebar"));

        // line 268
        echo "\t\t\t<!-- ======= Sidebar ======= -->
\t\t\t<aside id=\"sidebar\" class=\"sidebar\">

\t\t\t\t<ul
\t\t\t\t\tclass=\"sidebar-nav\" id=\"sidebar-nav\">


\t\t\t\t\t<!-- End Dashboard Nav -->

\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Evenements</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"components-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>
\t\t\t\t\t<!-- End Evenements Nav -->

\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#utilisateurs-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Utilisateurs</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"utilisateurs-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t\t<ul id=\"utilisateurs-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>
\t\t\t\t\t<!-- End Utilisateurs Nav -->
\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#blogs-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Blogs</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"blogs-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>
\t\t\t\t\t<!-- End blogs Nav -->
\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#Hotels-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Hotels</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"Hotels-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>


\t\t\t\t</ul>

\t\t\t</aside>
\t\t\t<!-- End Sidebar-->
\t\t";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 322
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 324
    public function block_footer($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "footer"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "footer"));

        // line 325
        echo "\t\t\t<!-- ======= Footer ======= -->
\t\t\t<footer id=\"footer\" class=\"footer\">
\t\t\t\t<div class=\"copyright\">
\t\t\t\t\t&copy; Copyright
\t\t\t\t\t<strong>
\t\t\t\t\t\t<span>NiceAdmin</span>
\t\t\t\t\t</strong>. All Rights Reserved
\t\t\t\t</div>
\t\t\t\t<div class=\"credits\">
\t\t\t\t\t<!-- All the links in the footer should remain intact. -->
\t\t\t\t\t<!-- You can delete the links only if you purchased the pro version. -->
\t\t\t\t\t<!-- Licensing information: https://bootstrapmade.com/license/ -->
\t\t\t\t\t<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
\t\t\t\t\tDesigned by
\t\t\t\t\t\t<a href=\"https://bootstrapmade.com/\"> BootstrapMade</a>
\t\t\t\t</div>
\t\t\t</footer>
\t\t\t<!-- End Footer -->
\t\t";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "base.html.twig";
    }

    public function getDebugInfo()
    {
        return array (  589 => 325,  579 => 324,  561 => 322,  499 => 268,  489 => 267,  417 => 204,  400 => 190,  383 => 176,  251 => 46,  241 => 45,  229 => 41,  223 => 38,  219 => 37,  215 => 36,  211 => 35,  207 => 34,  203 => 33,  199 => 32,  195 => 31,  192 => 30,  182 => 29,  170 => 26,  164 => 23,  159 => 21,  155 => 20,  151 => 19,  147 => 18,  143 => 17,  139 => 16,  131 => 10,  121 => 9,  101 => 6,  90 => 344,  88 => 324,  85 => 323,  83 => 322,  80 => 321,  78 => 267,  75 => 266,  73 => 45,  69 => 43,  67 => 29,  64 => 28,  62 => 9,  59 => 8,  57 => 6,  50 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<!DOCTYPE html>
<html>
\t<head>
\t\t<meta charset=\"UTF-8\">
\t\t<title>
\t\t\t{% block title %}Welcome!
\t\t\t{% endblock %}
\t\t</title>
\t\t{% block stylesheets %}
\t\t\t<!-- Google Fonts -->
\t\t\t<link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">
\t\t\t<link
\t\t\thref=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">

\t\t\t<!-- Vendor CSS Files -->
\t\t\t<link href=\"{{ asset('admin/vendor/bootstrap/css/bootstrap.min.css') }}\" rel=\"stylesheet\">
\t\t\t<link href=\"{{ asset('admin/vendor/bootstrap-icons/bootstrap-icons.css') }}\" rel=\"stylesheet\">
\t\t\t<link href=\"{{ asset('admin/vendor/boxicons/css/boxicons.min.css') }}\" rel=\"stylesheet\">
\t\t\t<link href=\"{{ asset('admin/vendor/quill/quill.snow.css') }}\" rel=\"stylesheet\">
\t\t\t<link href=\"{{ asset('admin/vendor/quill/quill.bubble.css') }}\" rel=\"stylesheet\">
\t\t\t<link href=\"{{ asset('admin/vendor/remixicon/remixicon.css') }}\" rel=\"stylesheet\">
\t\t\t<link
\t\t\thref=\"{{ asset('admin/vendor/simple-datatables/style.css') }}\" rel=\"stylesheet\">

\t\t\t<!-- Template Main CSS File -->
\t\t\t<link href=\"{{ asset('admin/css/style.css') }}\" rel=\"stylesheet\">
\t\t{% endblock %}

\t\t{% block javascripts %}
\t\t\t<!-- Vendor JS Files -->
\t\t\t<script src=\"{{ asset('admin/vendor/apexcharts/apexcharts.min.js') }}\"></script>
\t\t\t<script src=\"{{ asset('admin/vendor/bootstrap/js/bootstrap.bundle.min.js') }}\"></script>
\t\t\t<script src=\"{{ asset('admin/vendor/chart.js/chart.min.js') }}\"></script>
\t\t\t<script src=\"{{ asset('admin/vendor/echarts/echarts.min.js') }}\"></script>
\t\t\t<script src=\"{{ asset('admin/vendor/quill/quill.min.js') }}\"></script>
\t\t\t<script src=\"{{ asset('admin/vendor/simple-datatables/simple-datatables.js') }}\"></script>
\t\t\t<script src=\"{{ asset('admin/vendor/tinymce/tinymce.min.js') }}\"></script>
\t\t\t<script src=\"{{ asset('admin/vendor/php-email-form/validate.js') }}\"></script>

\t\t\t<!-- Template Main JS File -->
\t\t\t<script src=\"{{ asset('admin/js/main.js') }}\"></script>
\t\t{% endblock %}
\t</head>
\t<body>
\t\t{% block header %}
\t\t\t<!-- ======= Header ======= -->
\t\t\t<header id=\"header\" class=\"header fixed-top d-flex align-items-center\">

\t\t\t\t<div class=\"d-flex align-items-center justify-content-between\">

\t\t\t\t\t<i class=\"bi bi-list toggle-sidebar-btn\"></i>
\t\t\t\t</div>
\t\t\t\t<!-- End Logo -->

\t\t\t\t<div class=\"search-bar\">
\t\t\t\t\t<form class=\"search-form d-flex align-items-center\" method=\"POST\" action=\"#\">
\t\t\t\t\t\t<input type=\"text\" name=\"query\" placeholder=\"Search\" title=\"Enter search keyword\">
\t\t\t\t\t\t<button type=\"submit\" title=\"Search\">
\t\t\t\t\t\t\t<i class=\"bi bi-search\"></i>
\t\t\t\t\t\t</button>
\t\t\t\t\t</form>
\t\t\t\t</div>
\t\t\t\t<!-- End Search Bar -->

\t\t\t\t<nav class=\"header-nav ms-auto\">
\t\t\t\t\t<ul class=\"d-flex align-items-center\">

\t\t\t\t\t\t<li class=\"nav-item d-block d-lg-none\">
\t\t\t\t\t\t\t<a class=\"nav-link nav-icon search-bar-toggle \" href=\"#\">
\t\t\t\t\t\t\t\t<i class=\"bi bi-search\"></i>
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Search Icon-->

\t\t\t\t\t\t<li class=\"nav-item dropdown\">

\t\t\t\t\t\t\t<a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">
\t\t\t\t\t\t\t\t<i class=\"bi bi-bell\"></i>
\t\t\t\t\t\t\t\t<span class=\"badge bg-primary badge-number\">4</span>
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t<!-- End Notification Icon -->

\t\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications\">
\t\t\t\t\t\t\t\t<li class=\"dropdown-header\">
\t\t\t\t\t\t\t\t\tYou have 4 new notifications
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<span class=\"badge rounded-pill bg-primary p-2 ms-2\">View all</span>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-exclamation-circle text-warning\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Lorem Ipsum</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>30 min. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-x-circle text-danger\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Atque rerum nesciunt</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>1 hr. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-check-circle text-success\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Sit rerum fuga</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>2 hrs. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"notification-item\">
\t\t\t\t\t\t\t\t\t<i class=\"bi bi-info-circle text-primary\"></i>
\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t<h4>Dicta reprehenderit</h4>
\t\t\t\t\t\t\t\t\t\t<p>Quae dolorem earum veritatis oditseno</p>
\t\t\t\t\t\t\t\t\t\t<p>4 hrs. ago</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li class=\"dropdown-footer\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">Show all notifications</a>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t<!-- End Notification Dropdown Items -->

\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Notification Nav -->

\t\t\t\t\t\t<li class=\"nav-item dropdown\">

\t\t\t\t\t\t\t<a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">
\t\t\t\t\t\t\t\t<i class=\"bi bi-chat-left-text\"></i>
\t\t\t\t\t\t\t\t<span class=\"badge bg-success badge-number\">3</span>
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t<!-- End Messages Icon -->

\t\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow messages\">
\t\t\t\t\t\t\t\t<li class=\"dropdown-header\">
\t\t\t\t\t\t\t\t\tYou have 3 new messages
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<span class=\"badge rounded-pill bg-primary p-2 ms-2\">View all</span>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"message-item\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<img src=\"{{ asset('admin/img/messages-1.jpg') }}\" alt=\"\" class=\"rounded-circle\">
\t\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t\t<h4>Maria Hudson</h4>
\t\t\t\t\t\t\t\t\t\t\t<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
\t\t\t\t\t\t\t\t\t\t\t<p>4 hrs. ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"message-item\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<img src=\"{{ asset('admin/img/messages-2.jpg') }}\" alt=\"\" class=\"rounded-circle\">
\t\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t\t<h4>Anna Nelson</h4>
\t\t\t\t\t\t\t\t\t\t\t<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
\t\t\t\t\t\t\t\t\t\t\t<p>6 hrs. ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"message-item\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">
\t\t\t\t\t\t\t\t\t\t<img src=\"{{ asset('admin/img/messages-3.jpg') }}\" alt=\"\" class=\"rounded-circle\">
\t\t\t\t\t\t\t\t\t\t<div>
\t\t\t\t\t\t\t\t\t\t\t<h4>David Muldon</h4>
\t\t\t\t\t\t\t\t\t\t\t<p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
\t\t\t\t\t\t\t\t\t\t\t<p>8 hrs. ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t\t<li class=\"dropdown-footer\">
\t\t\t\t\t\t\t\t\t<a href=\"#\">Show all messages</a>
\t\t\t\t\t\t\t\t</li>

\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t<!-- End Messages Dropdown Items -->

\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Messages Nav -->

\t\t\t\t\t\t<li
\t\t\t\t\t\t\tclass=\"nav-item dropdown pe-3\">


\t\t\t\t\t\t\t<!-- End Profile Iamge Icon -->

\t\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow profile\">

\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t\t<hr class=\"dropdown-divider\">
\t\t\t\t\t\t\t\t</li>


\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t<!-- End Profile Dropdown Items -->
\t\t\t\t\t\t</li>
\t\t\t\t\t\t<!-- End Profile Nav -->

\t\t\t\t\t</ul>
\t\t\t\t</nav>
\t\t\t\t<!-- End Icons Navigation -->

\t\t\t</header>
\t\t\t<!-- End Header -->
\t\t{% endblock %}

\t\t{% block sidebar %}
\t\t\t<!-- ======= Sidebar ======= -->
\t\t\t<aside id=\"sidebar\" class=\"sidebar\">

\t\t\t\t<ul
\t\t\t\t\tclass=\"sidebar-nav\" id=\"sidebar-nav\">


\t\t\t\t\t<!-- End Dashboard Nav -->

\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Evenements</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"components-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>
\t\t\t\t\t<!-- End Evenements Nav -->

\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#utilisateurs-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Utilisateurs</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"utilisateurs-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t\t<ul id=\"utilisateurs-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>
\t\t\t\t\t<!-- End Utilisateurs Nav -->
\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#blogs-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Blogs</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"blogs-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>
\t\t\t\t\t<!-- End blogs Nav -->
\t\t\t\t\t<li class=\"nav-item\">
\t\t\t\t\t\t<a class=\"nav-link collapsed\" data-bs-target=\"#Hotels-nav\" data-bs-toggle=\"collapse\" href=\"#\">
\t\t\t\t\t\t\t<i class=\"bi bi-menu-button-wide\"></i>
\t\t\t\t\t\t\t<span>Hotels</span>
\t\t\t\t\t\t\t<i class=\"bi bi-chevron-down ms-auto\"></i>
\t\t\t\t\t\t</a>
\t\t\t\t\t\t<ul id=\"Hotels-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\"></ul>
\t\t\t\t\t</li>


\t\t\t\t</ul>

\t\t\t</aside>
\t\t\t<!-- End Sidebar-->
\t\t{% endblock %}

\t\t{% block body %}{% endblock %}

\t\t{% block footer %}
\t\t\t<!-- ======= Footer ======= -->
\t\t\t<footer id=\"footer\" class=\"footer\">
\t\t\t\t<div class=\"copyright\">
\t\t\t\t\t&copy; Copyright
\t\t\t\t\t<strong>
\t\t\t\t\t\t<span>NiceAdmin</span>
\t\t\t\t\t</strong>. All Rights Reserved
\t\t\t\t</div>
\t\t\t\t<div class=\"credits\">
\t\t\t\t\t<!-- All the links in the footer should remain intact. -->
\t\t\t\t\t<!-- You can delete the links only if you purchased the pro version. -->
\t\t\t\t\t<!-- Licensing information: https://bootstrapmade.com/license/ -->
\t\t\t\t\t<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
\t\t\t\t\tDesigned by
\t\t\t\t\t\t<a href=\"https://bootstrapmade.com/\"> BootstrapMade</a>
\t\t\t\t</div>
\t\t\t</footer>
\t\t\t<!-- End Footer -->
\t\t{% endblock %}
\t</body>
</html>", "base.html.twig", "C:\\Users\\HP\\pidev1\\templates\\base.html.twig");
    }
}
