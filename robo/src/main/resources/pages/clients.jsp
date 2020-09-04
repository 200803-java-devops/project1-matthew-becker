
<div
    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Clients</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <div class="alert alert-warning alert-dismissible fade hide" role="alert" id="dashboard_alerts">
            <span id="dashboard_alert_text">Loading...</span>
            <button type="button" class="close" xaria-label="Close" onclick="hideDashboardAlert()">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%-- <div class="btn-group mr-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
        </div>
        <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            This week
        </button> --%>
    </div>
</div>

<h3>User: ${sessionScope.user}</h3>
<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
            <tr>
                <th>Project</th>
                <th>Status</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody id="clients_tbody">
            
        </tbody>
    </table>
</div>
