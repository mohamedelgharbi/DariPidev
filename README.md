# DariPidev

<!DOCTYPE html>
<html>
<body>

<h1>Dog Pet Select</h1>

<form action="resp/" method="post"> {% csrf_token %}
  <p>Please select pet size:</p>
  <input type="radio" checked id="small" name="size" value="small">
  <label for="small">Small</label><br>
  <input type="radio" id="medium" name="size" value="medium">
  <label for="medium">Medium</label><br>
  <input type="radio" id="large" name="size" value="large">
  <label for="large">Large</label>

  <br>  

  <p>Please select hair length:</p>
  <input type="radio" checked id="short" name="length" value="short">
  <label for="short">Short</label><br>
  <input type="radio" id="medium" name="length" value="medium">
  <label for="medium">Medium</label><br>  
  <input type="radio" id="long" name="length" value="long">
  <label for="long">Long</label><br>  
  <input type="submit" value="Submit">
</form>

</body>
</html>
