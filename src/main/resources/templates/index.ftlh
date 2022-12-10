[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Můj blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="/images/favicon.png">
</head>
<body>

<h1>Tady bude můj blog…</h1>

<ul>
    [#list seznamPostu as post]
        <li>
            <a href="detail/${post.slug?no_esc}"> ${post.title}</a> <br>
            ${post.perex} <br>
            ${post.body} <br>
            ${post.published?date} <br>


        </li>
    [/#list]
</ul>

</body>
</html>
