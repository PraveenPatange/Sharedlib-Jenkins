def call(String buildStatus = 'STARTED') {

    // If null, treat as SUCCESS
    buildStatus = buildStatus ?: 'SUCCESS'

    // Default values
    def colorCode = '#FF0000'  // RED
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"

    // Set color based on status
    if (buildStatus == 'STARTED') {
        colorCode = '#FFFF00'  // YELLOW
    } else if (buildStatus == 'SUCCESS') {
        colorCode = '#00FF00'  // GREEN
    } else {
        colorCode = '#FF0000'  // RED
    }

    // ✅ FIX: Add Slack credentials here
    slackSend(
        channel: '#praveen-project',
        color: colorCode,
        message: summary,
        teamDomain: 'devops-wells',          // your Slack workspace
        tokenCredentialId: 'slack-cred'     // Jenkins credential ID
    )
}
