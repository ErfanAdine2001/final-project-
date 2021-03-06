<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div class="container">
    <section id="content">
        <form action="/LoginPage.jsp">
            <h1>Login Form</h1>
            <div>
                <input type="text" placeholder="Email_ID" required="" id="username" name="username" />
            </div>
            <div>
                <input type="password" placeholder="Password" required="" id="password" name="password"/>
            </div>
            <div>
                <input type="submit" value="Log in" />
                <a href="#">Lost your password?</a>
                <a href="#">Register</a>
            </div>
        </form><!-- form -->

    </section><!-- content -->
</div><!-- container -->
</body>
</html>