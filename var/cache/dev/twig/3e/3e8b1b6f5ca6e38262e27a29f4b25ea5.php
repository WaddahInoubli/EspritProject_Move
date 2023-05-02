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

/* reclamation/index.html.twig */
class __TwigTemplate_bf7edb697eedf380f2def5a07917be2f extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doGetParent(array $context)
    {
        // line 1
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "reclamation/index.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "reclamation/index.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "reclamation/index.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

    }

    // line 3
    public function block_title($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        echo "Reclamation index
";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

    }

    // line 6
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 7
        echo "\t<main id=\"main\" class=\"main\">
\t\t<section class=\"section\">
\t\t\t<div class=\"row\">
\t\t\t\t<div class=\"col-lg-12\">

\t\t\t\t\t<div class=\"card\">
\t\t\t\t\t\t<div class=\"card-body\">
\t\t\t\t\t\t\t<h1>Reclamation index</h1>

\t\t\t\t\t\t\t<div class=\"form-group\">
\t\t\t\t\t\t\t\t<label for=\"search-input\">Search:</label>
\t\t\t\t\t\t\t\t<input type=\"text\" id=\"search-input\" class=\"form-control\" placeholder=\"Enter your search \">
\t\t\t\t\t\t\t</div>

\t\t\t\t\t\t\t<table id=\"userTable\" class=\"table table-striped\">
\t\t\t\t\t\t\t\t<thead>
\t\t\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t\t\t<th>Id</th>
\t\t\t\t\t\t\t\t\t<th>Objectif</th>
\t\t\t\t\t\t\t\t\t<th>Text</th>
\t\t\t\t\t\t\t\t\t<th>Etat</th>
\t\t\t\t\t\t\t\t\t<th>actions</th>
\t\t\t\t\t\t\t\t</tr>
\t\t\t\t\t\t\t\t</thead>
\t\t\t\t\t\t\t\t<tbody>
\t\t\t\t\t\t\t\t";
        // line 32
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["reclamations"]) || array_key_exists("reclamations", $context) ? $context["reclamations"] : (function () { throw new RuntimeError('Variable "reclamations" does not exist.', 32, $this->source); })()));
        $context['_iterated'] = false;
        foreach ($context['_seq'] as $context["_key"] => $context["reclamation"]) {
            // line 33
            echo "\t\t\t\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t\t\t\t<td>";
            // line 34
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["reclamation"], "id", [], "any", false, false, false, 34), "html", null, true);
            echo "</td>
\t\t\t\t\t\t\t\t\t\t<td>";
            // line 35
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["reclamation"], "objectif", [], "any", false, false, false, 35), "html", null, true);
            echo "</td>
\t\t\t\t\t\t\t\t\t\t<td>";
            // line 36
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["reclamation"], "text", [], "any", false, false, false, 36), "html", null, true);
            echo "</td>
\t\t\t\t\t\t\t\t\t\t<td>";
            // line 37
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["reclamation"], "etat", [], "any", false, false, false, 37), "html", null, true);
            echo "</td>
\t\t\t\t\t\t\t\t\t\t<td>
\t\t\t\t\t\t\t\t\t\t\t<a href=\"";
            // line 39
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_reclamation_show", ["id" => twig_get_attribute($this->env, $this->source, $context["reclamation"], "id", [], "any", false, false, false, 39)]), "html", null, true);
            echo "\">show</a>
\t\t\t\t\t\t\t\t\t\t\t<a href=\"";
            // line 40
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_reclamation_delete", ["id" => twig_get_attribute($this->env, $this->source, $context["reclamation"], "id", [], "any", false, false, false, 40)]), "html", null, true);
            echo "\">delete</a>
\t\t\t\t\t\t\t\t\t\t\t<a href=\"";
            // line 41
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_reclamation_edit", ["id" => twig_get_attribute($this->env, $this->source, $context["reclamation"], "id", [], "any", false, false, false, 41)]), "html", null, true);
            echo "\">edit</a>
\t\t\t\t\t\t\t\t\t\t</td>
\t\t\t\t\t\t\t\t\t</tr>
\t\t\t\t\t\t\t\t";
            $context['_iterated'] = true;
        }
        if (!$context['_iterated']) {
            // line 45
            echo "\t\t\t\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t\t\t\t<td colspan=\"5\">no records found</td>
\t\t\t\t\t\t\t\t\t</tr>
\t\t\t\t\t\t\t\t";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['reclamation'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 49
        echo "\t\t\t\t\t\t\t\t</tbody>
\t\t\t\t\t\t\t</table>
\t\t\t\t\t\t\t";
        // line 51
        echo $this->extensions['Knp\Bundle\PaginatorBundle\Twig\Extension\PaginationExtension']->render($this->env, (isset($context["reclamations"]) || array_key_exists("reclamations", $context) ? $context["reclamations"] : (function () { throw new RuntimeError('Variable "reclamations" does not exist.', 51, $this->source); })()));
        echo "
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t</section>
\t\t<a href=\"";
        // line 57
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_reclamation_new");
        echo "\">Create new</a>
\t</main>

\t<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>

\t<script>
\t\tfunction searchTable() {
\t\t\t// Get the search query from the input field
\t\t\tvar query = document.getElementById(\"search-input\").value;
\t\t\t// Send an AJAX request to the server
\t\t\t\$.ajax({
\t\t\t\turl: '";
        // line 68
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_reclamation_search");
        echo "',
\t\t\t\tmethod: 'GET',
\t\t\t\tdata: {query: query},
\t\t\t\tsuccess: function(data) {
\t\t\t\t\t// Parse the JSON data
\t\t\t\t\tvar recs = JSON.parse(data);
\t\t\t\t\t// Clear the existing table rows
\t\t\t\t\t\$(\"#userTable tbody\").empty();
\t\t\t\t\t// Loop through the search results and add new rows to the table
\t\t\t\t\tfor (var i = 0; i < recs.length; i++) {
\t\t\t\t\t\tvar rec = recs[i];
\t\t\t\t\t\tvar row = \"<tr>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.id + \"</td>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.objectif+ \" </td>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.text + \"</td>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.etat + \"</td>\" +
\t\t\t\t\t\t\t\t\"<td>\" +

\t\t\t\t\t\t\t\t\"</tr>\";
\t\t\t\t\t\t\$(\"#userTable tbody\").append(row);
\t\t\t\t\t}
\t\t\t\t}
\t\t\t});
\t\t}


\t\t\$(document).ready(function() {
\t\t\t// Update the search results whenever the search query changes
\t\t\t\$(\"#search-input\").on(\"input\", searchTable);
\t\t});
\t</script>
";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

    }

    public function getTemplateName()
    {
        return "reclamation/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  194 => 68,  180 => 57,  171 => 51,  167 => 49,  158 => 45,  149 => 41,  145 => 40,  141 => 39,  136 => 37,  132 => 36,  128 => 35,  124 => 34,  121 => 33,  116 => 32,  89 => 7,  79 => 6,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'base.html.twig' %}

{% block title %}Reclamation index
{% endblock %}

{% block body %}
\t<main id=\"main\" class=\"main\">
\t\t<section class=\"section\">
\t\t\t<div class=\"row\">
\t\t\t\t<div class=\"col-lg-12\">

\t\t\t\t\t<div class=\"card\">
\t\t\t\t\t\t<div class=\"card-body\">
\t\t\t\t\t\t\t<h1>Reclamation index</h1>

\t\t\t\t\t\t\t<div class=\"form-group\">
\t\t\t\t\t\t\t\t<label for=\"search-input\">Search:</label>
\t\t\t\t\t\t\t\t<input type=\"text\" id=\"search-input\" class=\"form-control\" placeholder=\"Enter your search \">
\t\t\t\t\t\t\t</div>

\t\t\t\t\t\t\t<table id=\"userTable\" class=\"table table-striped\">
\t\t\t\t\t\t\t\t<thead>
\t\t\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t\t\t<th>Id</th>
\t\t\t\t\t\t\t\t\t<th>Objectif</th>
\t\t\t\t\t\t\t\t\t<th>Text</th>
\t\t\t\t\t\t\t\t\t<th>Etat</th>
\t\t\t\t\t\t\t\t\t<th>actions</th>
\t\t\t\t\t\t\t\t</tr>
\t\t\t\t\t\t\t\t</thead>
\t\t\t\t\t\t\t\t<tbody>
\t\t\t\t\t\t\t\t{% for reclamation in reclamations %}
\t\t\t\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t\t\t\t<td>{{ reclamation.id }}</td>
\t\t\t\t\t\t\t\t\t\t<td>{{ reclamation.objectif }}</td>
\t\t\t\t\t\t\t\t\t\t<td>{{ reclamation.text }}</td>
\t\t\t\t\t\t\t\t\t\t<td>{{ reclamation.etat }}</td>
\t\t\t\t\t\t\t\t\t\t<td>
\t\t\t\t\t\t\t\t\t\t\t<a href=\"{{ path('app_reclamation_show', {'id': reclamation.id}) }}\">show</a>
\t\t\t\t\t\t\t\t\t\t\t<a href=\"{{ path('app_reclamation_delete', {'id': reclamation.id}) }}\">delete</a>
\t\t\t\t\t\t\t\t\t\t\t<a href=\"{{ path('app_reclamation_edit', {'id': reclamation.id}) }}\">edit</a>
\t\t\t\t\t\t\t\t\t\t</td>
\t\t\t\t\t\t\t\t\t</tr>
\t\t\t\t\t\t\t\t{% else %}
\t\t\t\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t\t\t\t<td colspan=\"5\">no records found</td>
\t\t\t\t\t\t\t\t\t</tr>
\t\t\t\t\t\t\t\t{% endfor %}
\t\t\t\t\t\t\t\t</tbody>
\t\t\t\t\t\t\t</table>
\t\t\t\t\t\t\t{{ knp_pagination_render(reclamations) }}
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t</section>
\t\t<a href=\"{{ path('app_reclamation_new') }}\">Create new</a>
\t</main>

\t<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>

\t<script>
\t\tfunction searchTable() {
\t\t\t// Get the search query from the input field
\t\t\tvar query = document.getElementById(\"search-input\").value;
\t\t\t// Send an AJAX request to the server
\t\t\t\$.ajax({
\t\t\t\turl: '{{ path(\"app_reclamation_search\") }}',
\t\t\t\tmethod: 'GET',
\t\t\t\tdata: {query: query},
\t\t\t\tsuccess: function(data) {
\t\t\t\t\t// Parse the JSON data
\t\t\t\t\tvar recs = JSON.parse(data);
\t\t\t\t\t// Clear the existing table rows
\t\t\t\t\t\$(\"#userTable tbody\").empty();
\t\t\t\t\t// Loop through the search results and add new rows to the table
\t\t\t\t\tfor (var i = 0; i < recs.length; i++) {
\t\t\t\t\t\tvar rec = recs[i];
\t\t\t\t\t\tvar row = \"<tr>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.id + \"</td>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.objectif+ \" </td>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.text + \"</td>\" +
\t\t\t\t\t\t\t\t\"<td>\" + rec.etat + \"</td>\" +
\t\t\t\t\t\t\t\t\"<td>\" +

\t\t\t\t\t\t\t\t\"</tr>\";
\t\t\t\t\t\t\$(\"#userTable tbody\").append(row);
\t\t\t\t\t}
\t\t\t\t}
\t\t\t});
\t\t}


\t\t\$(document).ready(function() {
\t\t\t// Update the search results whenever the search query changes
\t\t\t\$(\"#search-input\").on(\"input\", searchTable);
\t\t});
\t</script>
{% endblock %}
", "reclamation/index.html.twig", "C:\\xampp\\htdocs\\pidev3a11_symfony\\templates\\reclamation\\index.html.twig");
    }
}
