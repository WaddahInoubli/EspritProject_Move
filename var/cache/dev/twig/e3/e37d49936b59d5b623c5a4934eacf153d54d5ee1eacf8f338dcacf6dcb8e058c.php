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

/* security/login.html.twig */
class __TwigTemplate_1a1f1326e74e3317cfac9d00aa1cf4de9649908acea47e0d7feac0ebb387295d extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/login.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/login.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html lang=\"en\">

<head>
    <meta charset=\"utf-8\">
    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">

    <title>Pages / Login - NiceAdmin Bootstrap Template</title>
    <meta content=\"\" name=\"description\">
    <meta content=\"\" name=\"keywords\">

    <!-- Favicons -->
    <link href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/img/favicon.png"), "html", null, true);
        echo "\" rel=\"icon\">
    <link href=\"";
        // line 14
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/img/apple-touch-icon.png"), "html", null, true);
        echo "\" rel=\"apple-touch-icon\">

    <!-- Google Fonts -->
    <link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">
    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">

    <link href=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/bootstrap/css/bootstrap.min.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
    <link href=\"";
        // line 21
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/bootstrap-icons/bootstrap-icons.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
    <link href=\"";
        // line 22
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/boxicons/css/boxicons.min.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
    <link href=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/quill/quill.snow.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
    <link href=\"";
        // line 24
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/quill/quill.bubble.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
    <link href=\"";
        // line 25
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/remixicon/remixicon.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">
    <link href=\"";
        // line 26
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/simple-datatables/style.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">

    <!-- Template Main CSS File -->
    <link  href=\"";
        // line 29
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/css/style.css"), "html", null, true);
        echo "\" rel=\"stylesheet\">

    <!-- =======================================================
    * Template Name: NiceAdmin
    * Updated: Mar 09 2023 with Bootstrap v5.2.3
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<main>
    <div class=\"container\">

        <section class=\"section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4\">
            <div class=\"container\">
                <div class=\"row justify-content-center\">
                    <div class=\"col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center\">

                        <div class=\"d-flex justify-content-center py-4\">
                            <a href=\"index.html\" class=\"logo d-flex align-items-center w-auto\">
                                <img src=\"assets/img/logo.png\" alt=\"\">
                                <span class=\"d-none d-lg-block\">NiceAdmin</span>
                            </a>
                        </div><!-- End Logo -->

                        <div class=\"card mb-3\">

                            <div class=\"card-body\">

                                <div class=\"pt-4 pb-2\">
                                    <h5 class=\"card-title text-center pb-0 fs-4\">Login to Your Account</h5>
                                    <p class=\"text-center small\">Enter your email & password to login</p>
                                </div>

                                <form method=\"post\" class=\"row g-3 needs-validation\">

                                    <div class=\"col-12\">
                                        <label for=\"yourUsername\" class=\"form-label\">Username</label>
                                        <div class=\"input-group has-validation\">
                                            <span class=\"input-group-text\" id=\"inputGroupPrepend\">@</span>
                                            <input type=\"text\" name=\"_username\" class=\"form-control\" id=\"yourUsername\" required>
                                            <div class=\"invalid-feedback\">Please enter your email.</div>
                                        </div>
                                    </div>

                                    <div class=\"col-12\">
                                        <label for=\"yourPassword\" class=\"form-label\">Password</label>
                                        <input type=\"password\" name=\"_password\" class=\"form-control\" id=\"yourPassword\" required>
                                        <div class=\"invalid-feedback\">Please enter your password!</div>
                                    </div>

                                    <div class=\"col-12\">
                                        <div class=\"form-check\">
                                            <input class=\"form-check-input\" type=\"checkbox\" name=\"remember\" value=\"true\" id=\"rememberMe\">
                                            <label class=\"form-check-label\" for=\"rememberMe\">Remember me</label>
                                        </div>
                                    </div>
                                    <div class=\"col-12\">
                                        <input type=\"hidden\" name=\"_csrf_token\" value=\"";
        // line 90
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken("authenticate"), "html", null, true);
        echo "\">
                                        ";
        // line 91
        if ((isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 91, $this->source); })())) {
            // line 92
            echo "                                            <div class=\"text-danger\">";
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\TranslationExtension']->trans(twig_get_attribute($this->env, $this->source, (isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 92, $this->source); })()), "messageKey", [], "any", false, false, false, 92), twig_get_attribute($this->env, $this->source, (isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 92, $this->source); })()), "messageData", [], "any", false, false, false, 92), "security"), "html", null, true);
            echo "</div>
                                        ";
        }
        // line 94
        echo "                                        <button class=\"btn btn-primary w-100\" type=\"submit\">Login</button>
                                    </div>
                                    <div class=\"col-12\">
                                        <p class=\"small mb-0\">Don't have account? <a href=\"pages-register.html\">Create an account</a></p>
                                    </div>
                                </form>

                            </div>
                        </div>

                        <div class=\"credits\">
                            <!-- All the links in the footer should remain intact. -->
                            <!-- You can delete the links only if you purchased the pro version. -->
                            <!-- Licensing information: https://bootstrapmade.com/license/ -->
                            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                            Designed by <a href=\"https://bootstrapmade.com/\">BootstrapMade</a>
                        </div>

                    </div>
                </div>
            </div>

        </section>

    </div>
</main><!-- End #main -->

<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>

<!-- Vendor JS Files -->
<script src=\"assets/vendor/apexcharts/apexcharts.min.js\"></script>
<script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>
<script src=\"assets/vendor/chart.js/chart.umd.js\"></script>
<script src=\"assets/vendor/echarts/echarts.min.js\"></script>
<script src=\"assets/vendor/quill/quill.min.js\"></script>
<script src=\"assets/vendor/simple-datatables/simple-datatables.js\"></script>
<script src=\"assets/vendor/tinymce/tinymce.min.js\"></script>
<script src=\"assets/vendor/php-email-form/validate.js\"></script>

<!-- Template Main JS File -->
<script src=\"assets/js/main.js\"></script>

</body>

</html>";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "security/login.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  176 => 94,  170 => 92,  168 => 91,  164 => 90,  100 => 29,  94 => 26,  90 => 25,  86 => 24,  82 => 23,  78 => 22,  74 => 21,  70 => 20,  61 => 14,  57 => 13,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<!DOCTYPE html>
<html lang=\"en\">

<head>
    <meta charset=\"utf-8\">
    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">

    <title>Pages / Login - NiceAdmin Bootstrap Template</title>
    <meta content=\"\" name=\"description\">
    <meta content=\"\" name=\"keywords\">

    <!-- Favicons -->
    <link href=\"{{ asset('assets/img/favicon.png') }}\" rel=\"icon\">
    <link href=\"{{ asset('assets/img/apple-touch-icon.png') }}\" rel=\"apple-touch-icon\">

    <!-- Google Fonts -->
    <link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">
    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">

    <link href=\"{{ asset('assets/vendor/bootstrap/css/bootstrap.min.css') }}\" rel=\"stylesheet\">
    <link href=\"{{ asset('assets/vendor/bootstrap-icons/bootstrap-icons.css') }}\" rel=\"stylesheet\">
    <link href=\"{{ asset('assets/vendor/boxicons/css/boxicons.min.css') }}\" rel=\"stylesheet\">
    <link href=\"{{ asset('assets/vendor/quill/quill.snow.css') }}\" rel=\"stylesheet\">
    <link href=\"{{ asset('assets/vendor/quill/quill.bubble.css') }}\" rel=\"stylesheet\">
    <link href=\"{{ asset('assets/vendor/remixicon/remixicon.css') }}\" rel=\"stylesheet\">
    <link href=\"{{ asset('assets/vendor/simple-datatables/style.css') }}\" rel=\"stylesheet\">

    <!-- Template Main CSS File -->
    <link  href=\"{{ asset('assets/css/style.css') }}\" rel=\"stylesheet\">

    <!-- =======================================================
    * Template Name: NiceAdmin
    * Updated: Mar 09 2023 with Bootstrap v5.2.3
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<main>
    <div class=\"container\">

        <section class=\"section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4\">
            <div class=\"container\">
                <div class=\"row justify-content-center\">
                    <div class=\"col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center\">

                        <div class=\"d-flex justify-content-center py-4\">
                            <a href=\"index.html\" class=\"logo d-flex align-items-center w-auto\">
                                <img src=\"assets/img/logo.png\" alt=\"\">
                                <span class=\"d-none d-lg-block\">NiceAdmin</span>
                            </a>
                        </div><!-- End Logo -->

                        <div class=\"card mb-3\">

                            <div class=\"card-body\">

                                <div class=\"pt-4 pb-2\">
                                    <h5 class=\"card-title text-center pb-0 fs-4\">Login to Your Account</h5>
                                    <p class=\"text-center small\">Enter your email & password to login</p>
                                </div>

                                <form method=\"post\" class=\"row g-3 needs-validation\">

                                    <div class=\"col-12\">
                                        <label for=\"yourUsername\" class=\"form-label\">Username</label>
                                        <div class=\"input-group has-validation\">
                                            <span class=\"input-group-text\" id=\"inputGroupPrepend\">@</span>
                                            <input type=\"text\" name=\"_username\" class=\"form-control\" id=\"yourUsername\" required>
                                            <div class=\"invalid-feedback\">Please enter your email.</div>
                                        </div>
                                    </div>

                                    <div class=\"col-12\">
                                        <label for=\"yourPassword\" class=\"form-label\">Password</label>
                                        <input type=\"password\" name=\"_password\" class=\"form-control\" id=\"yourPassword\" required>
                                        <div class=\"invalid-feedback\">Please enter your password!</div>
                                    </div>

                                    <div class=\"col-12\">
                                        <div class=\"form-check\">
                                            <input class=\"form-check-input\" type=\"checkbox\" name=\"remember\" value=\"true\" id=\"rememberMe\">
                                            <label class=\"form-check-label\" for=\"rememberMe\">Remember me</label>
                                        </div>
                                    </div>
                                    <div class=\"col-12\">
                                        <input type=\"hidden\" name=\"_csrf_token\" value=\"{{ csrf_token('authenticate') }}\">
                                        {% if error %}
                                            <div class=\"text-danger\">{{ error.messageKey|trans(error.messageData, 'security') }}</div>
                                        {% endif %}
                                        <button class=\"btn btn-primary w-100\" type=\"submit\">Login</button>
                                    </div>
                                    <div class=\"col-12\">
                                        <p class=\"small mb-0\">Don't have account? <a href=\"pages-register.html\">Create an account</a></p>
                                    </div>
                                </form>

                            </div>
                        </div>

                        <div class=\"credits\">
                            <!-- All the links in the footer should remain intact. -->
                            <!-- You can delete the links only if you purchased the pro version. -->
                            <!-- Licensing information: https://bootstrapmade.com/license/ -->
                            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                            Designed by <a href=\"https://bootstrapmade.com/\">BootstrapMade</a>
                        </div>

                    </div>
                </div>
            </div>

        </section>

    </div>
</main><!-- End #main -->

<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>

<!-- Vendor JS Files -->
<script src=\"assets/vendor/apexcharts/apexcharts.min.js\"></script>
<script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>
<script src=\"assets/vendor/chart.js/chart.umd.js\"></script>
<script src=\"assets/vendor/echarts/echarts.min.js\"></script>
<script src=\"assets/vendor/quill/quill.min.js\"></script>
<script src=\"assets/vendor/simple-datatables/simple-datatables.js\"></script>
<script src=\"assets/vendor/tinymce/tinymce.min.js\"></script>
<script src=\"assets/vendor/php-email-form/validate.js\"></script>

<!-- Template Main JS File -->
<script src=\"assets/js/main.js\"></script>

</body>

</html>", "security/login.html.twig", "C:\\xampp\\htdocs\\Web\\templates\\security\\login.html.twig");
    }
}
