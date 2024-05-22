Curl depuis Resp Achat


Requête : Get the list of content types available for the current user.

```console
curl -X GET --header 'Accept: application/json' --header 'Authorization: bearer OaBwmnJYmwP3OM69m9KorVu7BJNFPhe7YnJQ5YC_J1P_ZPBYJ4zmKyTPlGFG7lA_X_Eusden6TDpwALVH1_fQxQ4O2nj7QhEjlx-CJUoUg9rHczFxLFaXG86Xcv6W1zNZz98xIjXcOvO5iSGsTRdoPI20kgJ7kw-dlljuLV6baNc9YnmrmnXdGlzlvsEhsOq7xw1elZUQN_jwTV-W831o8qcvuQb_LKBmKOV1QNZ2hPWtYoreB70Nzt1xoTEJT55boqCCCDxMZ4PrY3ju4WEJb-2RkrX-eMOqQw98Zc012YQ0JChzp8-MXguQc5mZFtgq9YIdrWyid3zKU0HNvn-UZogbGM-YtaiSP_eJwzdfn2janIp6HAFrI5-eVL6rz61' 'http://157.26.83.80:2240/api/content-type/list'
```

Reponse :

```json
[{ "id": "90", "text": "Quittance", "selected": false }]

```




Requête : Get the document converted to PDF as a byte array.

```console
curl -X GET --header 'Accept: application/json' --header 'Authorization: bearer OaBwmnJYmwP3OM69m9KorVu7BJNFPhe7YnJQ5YC_J1P_ZPBYJ4zmKyTPlGFG7lA_X_Eusden6TDpwALVH1_fQxQ4O2nj7QhEjlx-CJUoUg9rHczFxLFaXG86Xcv6W1zNZz98xIjXcOvO5iSGsTRdoPI20kgJ7kw-dlljuLV6baNc9YnmrmnXdGlzlvsEhsOq7xw1elZUQN_jwTV-W831o8qcvuQb_LKBmKOV1QNZ2hPWtYoreB70Nzt1xoTEJT55boqCCCDxMZ4PrY3ju4WEJb-2RkrX-eMOqQw98Zc012YQ0JChzp8-MXguQc5mZFtgq9YIdrWyid3zKU0HNvn-UZogbGM-YtaiSP_eJwzdfn2janIp6HAFrI5-eVL6rz61' 'http://157.26.83.80:2240/api/document/715/display'
```

Reponse :

```json
{
  "Id": 0,
  "FileName": "2023.11.20-Resto-LaFeuilleDeVigne.pdf",
  "File": "JVBERi0xLjQKJeLjz9MK ... /* Big byte array */ ... jIxMzIKJSVFT0YK",
  "Base64File": null,
  "FileID": null
}

```

Requête : Get the document data.

```console
curl -X GET --header 'Accept: application/json' --header 'Authorization: bearer OaBwmnJYmwP3OM69m9KorVu7BJNFPhe7YnJQ5YC_J1P_ZPBYJ4zmKyTPlGFG7lA_X_Eusden6TDpwALVH1_fQxQ4O2nj7QhEjlx-CJUoUg9rHczFxLFaXG86Xcv6W1zNZz98xIjXcOvO5iSGsTRdoPI20kgJ7kw-dlljuLV6baNc9YnmrmnXdGlzlvsEhsOq7xw1elZUQN_jwTV-W831o8qcvuQb_LKBmKOV1QNZ2hPWtYoreB70Nzt1xoTEJT55boqCCCDxMZ4PrY3ju4WEJb-2RkrX-eMOqQw98Zc012YQ0JChzp8-MXguQc5mZFtgq9YIdrWyid3zKU0HNvn-UZogbGM-YtaiSP_eJwzdfn2janIp6HAFrI5-eVL6rz61' 'http://157.26.83.80:2240/api/document/715/metadata'

```

Reponse :

```json
{
  "ObjectID": 715,
  "OriginalID": 715,
  "ContentTypeID": 90,
  "ContentType": "Quittance v1.0",
  "HasAutomaticRecognition": false,
  "Source": null,
  "IpAddress": null,
  "CreationDate": "2024-05-08T16:17:15.78+02:00",
  "IsLastVersion": true,
  "IsDigitallySigned": false,
  "Version": " v1.0",
  "Author": "Sophie Rh",
  "Fields": [
    {
      "DefFieldID": 531,
      "Title": "Etat",
      "Type": 3,
      "Code": "Q_etat",
      "Value": "Refusée",
      "DefaultValue": "",
      "Observations": "",
      "IsRequired": false,
      "IsVisible": true,
      "IsReadOnly": true,
      "IsUnique": false,
      "Multivalue": false,
      "InternalTableID": null,
      "ListElements": [
        {
          "Id": "426",
          "DisplayValue": "Vérification",
          "Selected": false
        },
        {
          "Id": "425",
          "DisplayValue": "Manque d'informations",
          "Selected": false
        },
        {
          "Id": "424",
          "DisplayValue": "Refusée",
          "Selected": false
        },
        {
          "Id": "423",
          "DisplayValue": "Acceptée",
          "Selected": false
        },
        {
          "Id": "427",
          "DisplayValue": "Archivée",
          "Selected": false
        }
      ],
      "RelatedFieldsCodes": [],
      "Validations": {
        "Mask": null,
        "MinVal": null,
        "MaxVal": null,
        "Scale": null,
        "MaxLength": null
      }
    }
  ],
  "Attachment": null,
  "AttachmentFileName": "2023.11.20-Resto-LaFeuilleDeVigne.pdf",
  "Attachments": null
}

```



Requête :

```console
curl -X POST --header 'Content-Type: application/x-www-form-urlencoded' --header 'Accept: application/json' --header 'Authorization: bearer OaBwmnJYmwP3OM69m9KorVu7BJNFPhe7YnJQ5YC_J1P_ZPBYJ4zmKyTPlGFG7lA_X_Eusden6TDpwALVH1_fQxQ4O2nj7QhEjlx-CJUoUg9rHczFxLFaXG86Xcv6W1zNZz98xIjXcOvO5iSGsTRdoPI20kgJ7kw-dlljuLV6baNc9YnmrmnXdGlzlvsEhsOq7xw1elZUQN_jwTV-W831o8qcvuQb_LKBmKOV1QNZ2hPWtYoreB70Nzt1xoTEJT55boqCCCDxMZ4PrY3ju4WEJb-2RkrX-eMOqQw98Zc012YQ0JChzp8-MXguQc5mZFtgq9YIdrWyid3zKU0HNvn-UZogbGM-YtaiSP_eJwzdfn2janIp6HAFrI5-eVL6rz61' -d '{ \ 
 "searchPattern":"_author_|s05|%MYSELF%|string;AND;Q_etat|l01|Vérification|list","searchAllVersions":true, \ 
 "contentTypeIDs":"90" \ 
 }' 'http://157.26.83.80:2240/api/search/advanced'
```

Reponse :

```json
Non testé
```
