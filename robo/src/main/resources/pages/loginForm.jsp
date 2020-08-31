<div
    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Github Login </h1>
</div>

<form action="/gitlogin.do" method="POST">
    <div class="form-group">
        <label for="exampleInputEmail1">User</label>
        <input type="user" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
            placeholder="Enter Username" name="user">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pass">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>