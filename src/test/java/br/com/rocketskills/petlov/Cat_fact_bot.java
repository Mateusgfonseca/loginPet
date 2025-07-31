{
    "version": "0.4",
    "start": "start",
    "states": [
        {
            "id": "start",
            "name": "Start",
            "contentActions": [
                {
                    "type": "SendMessage",
                    "value": "Hi there! \ud83d\udc31 Want to learn a fun cat fact? Type anything to continue."
                }
            ],
            "transitions": [
                {
                    "nextState": "wait_input",
                    "condition": "true"
                }
            ],
            "onEnter": [],
            "onReceive": []
        },
        {
            "id": "wait_input",
            "name": "Wait Input",
            "contentActions": [],
            "inputActions": [
                {
                    "type": "ProcessInput",
                    "value": ""
                }
            ],
            "transitions": [
                {
                    "nextState": "get_cat_fact",
                    "condition": "true"
                }
            ],
            "onEnter": [],
            "onReceive": []
        },
        {
            "id": "get_cat_fact",
            "name": "Get Cat Fact",
            "contentActions": [],
            "transitions": [
                {
                    "nextState": "show_fact",
                    "condition": "true"
                }
            ],
            "onEnter": [
                {
                    "type": "ProcessHttp",
                    "settings": {
                        "method": "GET",
                        "url": "https://catfact.ninja/fact",
                        "headers": {},
                        "body": "",
                        "timeout": 30000,
                        "responseType": "json",
                        "saveResponseAs": "cat_fact_response"
                    }
                }
            ],
            "onReceive": []
        },
        {
            "id": "show_fact",
            "name": "Show Fact",
            "contentActions": [
                {
                    "type": "SendMessage",
                    "value": "\ud83d\udc3e Did you know?\n{{cat_fact_response@body.fact}}"
                }
            ],
            "transitions": [
                {
                    "nextState": "start",
                    "condition": "true"
                }
            ],
            "onEnter": [],
            "onReceive": []
        }
    ]
}