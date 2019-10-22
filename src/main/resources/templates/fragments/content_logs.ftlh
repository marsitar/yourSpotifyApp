<div class="container" style="margin-top:30px">
    <div class="container-fluid">
      <table class="table table-borderless">
        <tr>
          <td style="text-align: center"><h2>User's logs</h2></td>
        </tr>
      </table>
    </div>

    <div class="container">
        <ul class="list-group" id="result"></ul>
        <#if logs?? >
        <table class="table table-sm" style="text-align: center">
          <thead>
              <tr>
                <th scope="col" style="width: 5%">ID</th>
                <th scope="col" style="width: 95%">Log</th>
              </tr>
          </thead>
              <tbody>
                  <#if logs?? >
                      <#list logs>
                          <#items as log>
                            <tr>
                              <td>${log_index+1}.</td>
                              <td>${log}</td>
                            </tr>
                          </#items>
                      </#list>
                  </#if>
              </tbody>
              <#elseif errorMessage??>
                <div class="alert alert-danger" role="alert" style="text-align: center">
                  <strong>${errorMessage}</strong>
                </div>
              <#else>
                <div class="alert alert-secondary" role="alert" style="text-align: center">
                  <strong>You haven't got any favourite artists yet. Please add some in Artist's Browser view.</strong>
                </div>
            </table>
        </#if>
    </div>
    <script src="/js/artists.js"></script>
</div>