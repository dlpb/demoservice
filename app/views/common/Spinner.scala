package common

import scala.xml.NodeSeq

object Spinner {

  private val spinnerCss =
    """#floatingCirclesG{
      |position:relative;
      |width:64px;
      |height:64px;
      |-moz-transform:scale(0.6);
      |-webkit-transform:scale(0.6);
      |-ms-transform:scale(0.6);
      |-o-transform:scale(0.6);
      |transform:scale(0.6);
      |}
      |
      |.f_circleG{
      |position:absolute;
      |background-color:#FFFFFF;
      |height:12px;
      |width:12px;
      |-moz-border-radius:6px;
      |-moz-animation-name:f_fadeG;
      |-moz-animation-duration:1.04s;
      |-moz-animation-iteration-count:infinite;
      |-moz-animation-direction:linear;
      |-webkit-border-radius:6px;
      |-webkit-animation-name:f_fadeG;
      |-webkit-animation-duration:1.04s;
      |-webkit-animation-iteration-count:infinite;
      |-webkit-animation-direction:linear;
      |-ms-border-radius:6px;
      |-ms-animation-name:f_fadeG;
      |-ms-animation-duration:1.04s;
      |-ms-animation-iteration-count:infinite;
      |-ms-animation-direction:linear;
      |-o-border-radius:6px;
      |-o-animation-name:f_fadeG;
      |-o-animation-duration:1.04s;
      |-o-animation-iteration-count:infinite;
      |-o-animation-direction:linear;
      |border-radius:6px;
      |animation-name:f_fadeG;
      |animation-duration:1.04s;
      |animation-iteration-count:infinite;
      |animation-direction:linear;
      |}
      |
      |#frotateG_01{
      |left:0;
      |top:26px;
      |-moz-animation-delay:0.39s;
      |-webkit-animation-delay:0.39s;
      |-ms-animation-delay:0.39s;
      |-o-animation-delay:0.39s;
      |animation-delay:0.39s;
      |}
      |
      |#frotateG_02{
      |left:8px;
      |top:8px;
      |-moz-animation-delay:0.52s;
      |-webkit-animation-delay:0.52s;
      |-ms-animation-delay:0.52s;
      |-o-animation-delay:0.52s;
      |animation-delay:0.52s;
      |}
      |
      |#frotateG_03{
      |left:26px;
      |top:0;
      |-moz-animation-delay:0.65s;
      |-webkit-animation-delay:0.65s;
      |-ms-animation-delay:0.65s;
      |-o-animation-delay:0.65s;
      |animation-delay:0.65s;
      |}
      |
      |#frotateG_04{
      |right:8px;
      |top:8px;
      |-moz-animation-delay:0.78s;
      |-webkit-animation-delay:0.78s;
      |-ms-animation-delay:0.78s;
      |-o-animation-delay:0.78s;
      |animation-delay:0.78s;
      |}
      |
      |#frotateG_05{
      |right:0;
      |top:26px;
      |-moz-animation-delay:0.91s;
      |-webkit-animation-delay:0.91s;
      |-ms-animation-delay:0.91s;
      |-o-animation-delay:0.91s;
      |animation-delay:0.91s;
      |}
      |
      |#frotateG_06{
      |right:8px;
      |bottom:8px;
      |-moz-animation-delay:1.04s;
      |-webkit-animation-delay:1.04s;
      |-ms-animation-delay:1.04s;
      |-o-animation-delay:1.04s;
      |animation-delay:1.04s;
      |}
      |
      |#frotateG_07{
      |left:26px;
      |bottom:0;
      |-moz-animation-delay:1.17s;
      |-webkit-animation-delay:1.17s;
      |-ms-animation-delay:1.17s;
      |-o-animation-delay:1.17s;
      |animation-delay:1.17s;
      |}
      |
      |#frotateG_08{
      |left:8px;
      |bottom:8px;
      |-moz-animation-delay:1.3s;
      |-webkit-animation-delay:1.3s;
      |-ms-animation-delay:1.3s;
      |-o-animation-delay:1.3s;
      |animation-delay:1.3s;
      |}
      |
      |@-moz-keyframes f_fadeG{
      |0%{
      |background-color:#000000}
      |
      |100%{
      |background-color:#FFFFFF}
      |
      |}
      |
      |@-webkit-keyframes f_fadeG{
      |0%{
      |background-color:#000000}
      |
      |100%{
      |background-color:#FFFFFF}
      |
      |}
      |
      |@-ms-keyframes f_fadeG{
      |0%{
      |background-color:#000000}
      |
      |100%{
      |background-color:#FFFFFF}
      |
      |}
      |
      |@-o-keyframes f_fadeG{
      |0%{
      |background-color:#000000}
      |
      |100%{
      |background-color:#FFFFFF}
      |
      |}
      |
      |@keyframes f_fadeG{
      |0%{
      |background-color:#000000}
      |
      |100%{
      |background-color:#FFFFFF}
      |
      |}
      |""".stripMargin

  val html: NodeSeq = {
    <style>
      {spinnerCss}
    </style>
      <div id="floatingCirclesG">
        <div class="f_circleG" id="frotateG_01">
        </div>
        <div class="f_circleG" id="frotateG_02">
        </div>
        <div class="f_circleG" id="frotateG_03">
        </div>
        <div class="f_circleG" id="frotateG_04">
        </div>
        <div class="f_circleG" id="frotateG_05">
        </div>
        <div class="f_circleG" id="frotateG_06">
        </div>
        <div class="f_circleG" id="frotateG_07">
        </div>
        <div class="f_circleG" id="frotateG_08">
        </div>
      </div>
  }

}