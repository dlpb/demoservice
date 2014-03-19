package common


object JavaScript {

  val jQueryJs =
    "/assets/javascripts/jquery-1.10.2.min.js" ::
    Nil map { toScriptTag }

  val angularJs =
      "/assets/javascripts/angular.js" :: // 1.0.7
      "/assets/javascripts/angular-route.min.js" :: // 1.0.7
      "/assets/javascripts/underscore-1.5.2.min.js" ::
      "/assets/javascripts/angular-dragdrop.js" ::
      "/assets/javascripts/angular-resource.js" ::
      "/assets/javascripts/angular-sanitize.js" ::
      "/assets/javascripts/angular-animate.js" ::
      Nil map { toScriptTag }

  val angularAppJs =
    "/assets/app/namespace.js" ::
    "/assets/app/controllers/vote_ctrl.js" ::
    "/assets/app/controllers/admin_ctrl.js" ::
    "/assets/app/controllers/result_ctrl.js" ::
    "/assets/app/app.js" ::
    Nil map { toScriptTag }

  val bootstrapJs =
    "/assets/javascripts/bootstrap.js" ::
    "/assets/javascripts/Chart.js" ::
      "/assets/javascripts/moment.js" ::
      "/assets/javascripts/bootstrap-datepicker.js" ::
      Nil map { toScriptTag }

  def toScriptTag(url: String) = <script src={url} type="text/javascript"></script>
}
