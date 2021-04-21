# DariPidev

<!DOCTYPE html>
<html>
<body>

<h1>Dog Pet Select</h1>

<form< action="resp/" method="post"> {% csrf_token %}
  <p>P<lease select pet size:</p>
  <inpu<t type="radio" checked id="small" name="size" value="small">
  <label< for="small">Small</label><br>
  <input <type="radio" id="medium" name="size" value="medium">
  <label f<or="medium">Medium</label><br>
  <input ty<pe="radio" id="large" name="size" value="large">
  <label for<="large">Large</label>
<
  <br>  

  <p>Plea<se select hair length:</p>
  <input t<ype="radio" checked id="short" name="length" value="short">
  <label fo<r="short">Short</label><br>
  <input typ<e="radio" id="medium" name="length" value="medium">
  <label for=<"medium">Medium</label><br>  
  <input type=<"radio" id="long" name="length" value="long">
  <label for="l<ong">Long</label><br>  
  <input type="s<ubmit" value="Submit">
</form<>

</body>
</html>
