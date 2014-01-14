package common

import play.api.libs.json.{JsArray, Json}
import play.api.templates._

object UiFragments {

  val navBar = {

    // todo extract as html file
    val htmlValue = s"""        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                      |            <!-- Brand and toggle get grouped for better mobile display -->
                      |                <ul id="navnorm" class="nav navbar-nav hidden-xs">
                      |                <li>
                      |                  <a href="/">Vote</a>
                      |                </li>
                      |                <li>
                      |                  <a href="#/admin">Admin</a>
                      |                </li>
                      |                <li>
                      |                  <a href="#/results">Results</a>
                      |                </li>
                      |
                      |                </ul>
                      |                <ul class="nav navbar-nav visible-xs">
                      |                <li>
                      |                  <a id='shownav'>Menu</a>
                      |                </li>
                      |                </ul>
                      |                </nav>
                      |
                      |""".stripMargin

    HtmlFormat.raw(htmlValue)
  }

}