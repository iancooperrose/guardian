package contracts.membership

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description: "get the list of out the memberships in the database."
    request {
        method GET()
        urlPath("/memberships")
    }
    response {
        status 200
        body(
                [
                        [
                                id: 1,
                                member: [
                                    commonName: "Lizzie",
                                        pictures: [
                                                [
                                                        name: "elizabeth_cooper_rose.jpeg"
                                                ]
                                        ]
                                ],
                                guardians: [
                                      [
                                              commonName: "Ian",
                                              pictures: [
                                                      name: "ian_cooper_rose.jpeg"
                                              ],
                                              contacts: [
                                                      [
                                                              type: "phone"
                                                      ],
                                                      [
                                                              type: "txt"
                                                      ],
                                                      [
                                                              type: "slack"
                                                      ],
                                                      [
                                                              type: "twitter"
                                                      ]
                                              ]
                                      ],
                                      [
                                              commonName: "Laurel",
                                              pictures: [
                                                      name: "laurel_marie_pickard.jpeg"
                                              ],
                                              contacts: [
                                                      [
                                                              type: "phone"
                                                      ],
                                                      [
                                                              type: "txt"
                                                      ],
                                                      [
                                                              type: "slack"
                                                      ]
                                              ]
                                      ]
                                ],
                                term: [
                                    duration: 4
                                ],
                                organization: [
                                                name: "Arisia"
                                ],
                                level: "TURTLE",
                        ],
                        [
                                id: 2,
                                member: [
                                        commonName: "Katie"
                                ]
                        ],
                        [
                                id: 3,
                                member: [
                                        commonName: "Connor"
                                ]
                        ],
                        [
                                id: 4,
                                member: [
                                        commonName: "Penny"
                                ]
                        ],
                        [
                                id: 5,
                                member: [
                                        commonName: "Max"
                                ]
                        ]

                ]

//                '''
//            [
//              {
//                "id": 1,
//                "member": {
//                  "id": 1,
//                  "firstName": "Elizabeth",
//                  "middleName": "Cooper",
//                  "lastName": "Rose",
//                  "nameSuffix": "II",
//                  "commonName": "Lizzie",
//                  "dateOfBirth": "2015-09-01",
//                  "pictures": [
//                    {
//                      "id": 1,
//                      "type": "profile",
//                      "isDefault": true,
//                      "name": "elizabeth_cooper_rose.jpeg",
//                      "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1",
//                      "mediaType": "image/jpeg",
//                      "height": 300,
//                      "width": 300,
//                      "timeAdded": "2018-08-18T03:27:45"
//                    }
//                  ],
//                  "contacts": null
//                },
//                "guardians": [
//                  {
//                    "id": 7,
//                    "firstName": "Ian",
//                    "middleName": "Cooper",
//                    "lastName": "Rose",
//                    "nameSuffix": null,
//                    "commonName": "Ian",
//                    "dateOfBirth": "1969-12-22",
//                    "pictures": [
//                      {
//                        "id": 7,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "ian_cooper_rose.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:32:23"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 1,
//                        "type": "phone",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 2,
//                        "type": "txt",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 3,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 4,
//                        "type": "twitter",
//                        "value": "ian.cooper.rose",
//                        "contactOrder": 0,
//                        "notificationOrder": 3
//                      }
//                    ]
//                  },
//                  {
//                    "id": 8,
//                    "firstName": "Aimee",
//                    "middleName": "Katherine",
//                    "lastName": "Bouchard",
//                    "nameSuffix": null,
//                    "commonName": "Aimee",
//                    "dateOfBirth": "1980-07-29",
//                    "pictures": [
//                      {
//                        "id": 8,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "aimee_katherine_bouchard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:33:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 8,
//                        "type": "phone",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 9,
//                        "type": "txt",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 10,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 9,
//                    "firstName": "Michelle",
//                    "middleName": "Louise",
//                    "lastName": "Driscoll",
//                    "nameSuffix": null,
//                    "commonName": "Michelle",
//                    "dateOfBirth": "1979-05-06",
//                    "pictures": [
//                      {
//                        "id": 9,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "michelle_louise_driscoll.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/9",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:34:15"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 11,
//                        "type": "phone",
//                        "value": "(860) 977-3131",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 12,
//                        "type": "txt",
//                        "value": "(860) 977-3131",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 13,
//                        "type": "slack",
//                        "value": "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 14,
//                        "type": "facebook",
//                        "value": "9024704",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 6,
//                    "firstName": "Laurel",
//                    "middleName": "Marie",
//                    "lastName": "Pickard",
//                    "nameSuffix": null,
//                    "commonName": "Laurel",
//                    "dateOfBirth": "1982-10-18",
//                    "pictures": [
//                      {
//                        "id": 6,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "laurel_marie_pickard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:31:37"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 5,
//                        "type": "phone",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 6,
//                        "type": "txt",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 7,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 10,
//                    "firstName": "Michael",
//                    "middleName": "Andrew",
//                    "lastName": "Schneider",
//                    "nameSuffix": null,
//                    "commonName": "Micah",
//                    "dateOfBirth": "1971-06-18",
//                    "pictures": [
//                      {
//                        "id": 10,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "michael_andrew_schneider.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/10",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:35:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 15,
//                        "type": "phone",
//                        "value": "(413) 626-9760",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 16,
//                        "type": "txt",
//                        "value": "(413) 626-9760",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 17,
//                        "type": "slack",
//                        "value": "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  }
//                ],
//                "start": "2019-01-18",
//                "duration": 4,
//                "organization": {
//                  "id": 1,
//                  "name": "Arisia"
//                },
//                "level": "TURTLE"
//              },
//              {
//                "id": 2,
//                "member": {
//                  "id": 2,
//                  "firstName": "Kathleen",
//                  "middleName": "Louise",
//                  "lastName": "Bouchard",
//                  "nameSuffix": null,
//                  "commonName": "Katie",
//                  "dateOfBirth": "2013-10-09",
//                  "pictures": [
//                    {
//                      "id": 2,
//                      "type": "profile",
//                      "isDefault": true,
//                      "name": "kathleen_louise_bouchard.jpeg",
//                      "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/2",
//                      "mediaType": "image/jpeg",
//                      "height": 300,
//                      "width": 300,
//                      "timeAdded": "2018-08-18T03:30:37"
//                    }
//                  ],
//                  "contacts": null
//                },
//                "guardians": [
//                  {
//                    "id": 8,
//                    "firstName": "Aimee",
//                    "middleName": "Katherine",
//                    "lastName": "Bouchard",
//                    "nameSuffix": null,
//                    "commonName": "Aimee",
//                    "dateOfBirth": "1980-07-29",
//                    "pictures": [
//                      {
//                        "id": 8,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "aimee_katherine_bouchard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:33:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 8,
//                        "type": "phone",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 9,
//                        "type": "txt",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 10,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 10,
//                    "firstName": "Michael",
//                    "middleName": "Andrew",
//                    "lastName": "Schneider",
//                    "nameSuffix": null,
//                    "commonName": "Micah",
//                    "dateOfBirth": "1971-06-18",
//                    "pictures": [
//                      {
//                        "id": 10,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "michael_andrew_schneider.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/10",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:35:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 15,
//                        "type": "phone",
//                        "value": "(413) 626-9760",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 16,
//                        "type": "txt",
//                        "value": "(413) 626-9760",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 17,
//                        "type": "slack",
//                        "value": "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 9,
//                    "firstName": "Michelle",
//                    "middleName": "Louise",
//                    "lastName": "Driscoll",
//                    "nameSuffix": null,
//                    "commonName": "Michelle",
//                    "dateOfBirth": "1979-05-06",
//                    "pictures": [
//                      {
//                        "id": 9,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "michelle_louise_driscoll.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/9",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:34:15"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 11,
//                        "type": "phone",
//                        "value": "(860) 977-3131",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 12,
//                        "type": "txt",
//                        "value": "(860) 977-3131",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 13,
//                        "type": "slack",
//                        "value": "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 14,
//                        "type": "facebook",
//                        "value": "9024704",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 7,
//                    "firstName": "Ian",
//                    "middleName": "Cooper",
//                    "lastName": "Rose",
//                    "nameSuffix": null,
//                    "commonName": "Ian",
//                    "dateOfBirth": "1969-12-22",
//                    "pictures": [
//                      {
//                        "id": 7,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "ian_cooper_rose.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:32:23"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 1,
//                        "type": "phone",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 2,
//                        "type": "txt",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 3,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 4,
//                        "type": "twitter",
//                        "value": "ian.cooper.rose",
//                        "contactOrder": 0,
//                        "notificationOrder": 3
//                      }
//                    ]
//                  },
//                  {
//                    "id": 6,
//                    "firstName": "Laurel",
//                    "middleName": "Marie",
//                    "lastName": "Pickard",
//                    "nameSuffix": null,
//                    "commonName": "Laurel",
//                    "dateOfBirth": "1982-10-18",
//                    "pictures": [
//                      {
//                        "id": 6,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "laurel_marie_pickard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:31:37"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 5,
//                        "type": "phone",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 6,
//                        "type": "txt",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 7,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  }
//                ],
//                "start": "2019-01-18",
//                "duration": 4,
//                "organization": {
//                  "id": 1,
//                  "name": "Arisia"
//                },
//                "level": "COMMET"
//              },
//              {
//                "id": 3,
//                "member": {
//                  "id": 3,
//                  "firstName": "Connor",
//                  "middleName": "Paul",
//                  "lastName": "Bouchard",
//                  "nameSuffix": null,
//                  "commonName": "Connor",
//                  "dateOfBirth": "2011-04-02",
//                  "pictures": [
//                    {
//                      "id": 3,
//                      "type": "profile",
//                      "isDefault": true,
//                      "name": "connor_paul_bouchard.jpeg",
//                      "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/3",
//                      "mediaType": "image/jpeg",
//                      "height": 300,
//                      "width": 300,
//                      "timeAdded": "2018-08-18T03:36:00"
//                    }
//                  ],
//                  "contacts": null
//                },
//                "guardians": [
//                  {
//                    "id": 8,
//                    "firstName": "Aimee",
//                    "middleName": "Katherine",
//                    "lastName": "Bouchard",
//                    "nameSuffix": null,
//                    "commonName": "Aimee",
//                    "dateOfBirth": "1980-07-29",
//                    "pictures": [
//                      {
//                        "id": 8,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "aimee_katherine_bouchard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:33:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 8,
//                        "type": "phone",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 9,
//                        "type": "txt",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 10,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 10,
//                    "firstName": "Michael",
//                    "middleName": "Andrew",
//                    "lastName": "Schneider",
//                    "nameSuffix": null,
//                    "commonName": "Micah",
//                    "dateOfBirth": "1971-06-18",
//                    "pictures": [
//                      {
//                        "id": 10,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "michael_andrew_schneider.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/10",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:35:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 15,
//                        "type": "phone",
//                        "value": "(413) 626-9760",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 16,
//                        "type": "txt",
//                        "value": "(413) 626-9760",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 17,
//                        "type": "slack",
//                        "value": "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 9,
//                    "firstName": "Michelle",
//                    "middleName": "Louise",
//                    "lastName": "Driscoll",
//                    "nameSuffix": null,
//                    "commonName": "Michelle",
//                    "dateOfBirth": "1979-05-06",
//                    "pictures": [
//                      {
//                        "id": 9,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "michelle_louise_driscoll.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/9",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:34:15"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 11,
//                        "type": "phone",
//                        "value": "(860) 977-3131",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 12,
//                        "type": "txt",
//                        "value": "(860) 977-3131",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 13,
//                        "type": "slack",
//                        "value": "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 14,
//                        "type": "facebook",
//                        "value": "9024704",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 7,
//                    "firstName": "Ian",
//                    "middleName": "Cooper",
//                    "lastName": "Rose",
//                    "nameSuffix": null,
//                    "commonName": "Ian",
//                    "dateOfBirth": "1969-12-22",
//                    "pictures": [
//                      {
//                        "id": 7,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "ian_cooper_rose.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:32:23"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 1,
//                        "type": "phone",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 2,
//                        "type": "txt",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 3,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 4,
//                        "type": "twitter",
//                        "value": "ian.cooper.rose",
//                        "contactOrder": 0,
//                        "notificationOrder": 3
//                      }
//                    ]
//                  },
//                  {
//                    "id": 6,
//                    "firstName": "Laurel",
//                    "middleName": "Marie",
//                    "lastName": "Pickard",
//                    "nameSuffix": null,
//                    "commonName": "Laurel",
//                    "dateOfBirth": "1982-10-18",
//                    "pictures": [
//                      {
//                        "id": 6,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "laurel_marie_pickard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:31:37"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 5,
//                        "type": "phone",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 6,
//                        "type": "txt",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 7,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  }
//                ],
//                "start": "2019-01-18",
//                "duration": 4,
//                "organization": {
//                  "id": 1,
//                  "name": "Arisia"
//                },
//                "level": "COMMET"
//              },
//              {
//                "id": 4,
//                "member": {
//                  "id": 4,
//                  "firstName": "Penelope",
//                  "middleName": "Ada",
//                  "lastName": "Pickard",
//                  "nameSuffix": null,
//                  "commonName": "Penny",
//                  "dateOfBirth": "2015-07-20",
//                  "pictures": [
//                    {
//                      "id": 4,
//                      "type": "profile",
//                      "isDefault": true,
//                      "name": "penelope_ada_pickard.jpeg",
//                      "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/4",
//                      "mediaType": "image/jpeg",
//                      "height": 300,
//                      "width": 300,
//                      "timeAdded": "2018-08-18T03:38:27"
//                    }
//                  ],
//                  "contacts": null
//                },
//                "guardians": [
//                  {
//                    "id": 6,
//                    "firstName": "Laurel",
//                    "middleName": "Marie",
//                    "lastName": "Pickard",
//                    "nameSuffix": null,
//                    "commonName": "Laurel",
//                    "dateOfBirth": "1982-10-18",
//                    "pictures": [
//                      {
//                        "id": 6,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "laurel_marie_pickard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:31:37"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 5,
//                        "type": "phone",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 6,
//                        "type": "txt",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 7,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 7,
//                    "firstName": "Ian",
//                    "middleName": "Cooper",
//                    "lastName": "Rose",
//                    "nameSuffix": null,
//                    "commonName": "Ian",
//                    "dateOfBirth": "1969-12-22",
//                    "pictures": [
//                      {
//                        "id": 7,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "ian_cooper_rose.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:32:23"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 1,
//                        "type": "phone",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 2,
//                        "type": "txt",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 3,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 4,
//                        "type": "twitter",
//                        "value": "ian.cooper.rose",
//                        "contactOrder": 0,
//                        "notificationOrder": 3
//                      }
//                    ]
//                  },
//                  {
//                    "id": 8,
//                    "firstName": "Aimee",
//                    "middleName": "Katherine",
//                    "lastName": "Bouchard",
//                    "nameSuffix": null,
//                    "commonName": "Aimee",
//                    "dateOfBirth": "1980-07-29",
//                    "pictures": [
//                      {
//                        "id": 8,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "aimee_katherine_bouchard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:33:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 8,
//                        "type": "phone",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 9,
//                        "type": "txt",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 10,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  }
//                ],
//                "start": "2019-01-18",
//                "duration": 4,
//                "organization": {
//                  "id": 1,
//                  "name": "Arisia"
//                },
//                "level": "TURTLE"
//              },
//              {
//                "id": 5,
//                "member": {
//                  "id": 5,
//                  "firstName": "Maxwell",
//                  "middleName": "Allen",
//                  "lastName": "Pickard",
//                  "nameSuffix": null,
//                  "commonName": "Max",
//                  "dateOfBirth": "2018-06-18",
//                  "pictures": [
//                    {
//                      "id": 5,
//                      "type": "profile",
//                      "isDefault": true,
//                      "name": "maxwell_allen_pickard.jpeg",
//                      "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/5",
//                      "mediaType": "image/jpeg",
//                      "height": 300,
//                      "width": 300,
//                      "timeAdded": "2018-08-18T03:37:28"
//                    }
//                  ],
//                  "contacts": null
//                },
//                "guardians": [
//                  {
//                    "id": 6,
//                    "firstName": "Laurel",
//                    "middleName": "Marie",
//                    "lastName": "Pickard",
//                    "nameSuffix": null,
//                    "commonName": "Laurel",
//                    "dateOfBirth": "1982-10-18",
//                    "pictures": [
//                      {
//                        "id": 6,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "laurel_marie_pickard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:31:37"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 5,
//                        "type": "phone",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 6,
//                        "type": "txt",
//                        "value": "(860) 558-9530",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 7,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  },
//                  {
//                    "id": 7,
//                    "firstName": "Ian",
//                    "middleName": "Cooper",
//                    "lastName": "Rose",
//                    "nameSuffix": null,
//                    "commonName": "Ian",
//                    "dateOfBirth": "1969-12-22",
//                    "pictures": [
//                      {
//                        "id": 7,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "ian_cooper_rose.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:32:23"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 1,
//                        "type": "phone",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 2,
//                        "type": "txt",
//                        "value": "(413) 626-6101",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 3,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      },
//                      {
//                        "id": 4,
//                        "type": "twitter",
//                        "value": "ian.cooper.rose",
//                        "contactOrder": 0,
//                        "notificationOrder": 3
//                      }
//                    ]
//                  },
//                  {
//                    "id": 8,
//                    "firstName": "Aimee",
//                    "middleName": "Katherine",
//                    "lastName": "Bouchard",
//                    "nameSuffix": null,
//                    "commonName": "Aimee",
//                    "dateOfBirth": "1980-07-29",
//                    "pictures": [
//                      {
//                        "id": 8,
//                        "type": "profile",
//                        "isDefault": true,
//                        "name": "aimee_katherine_bouchard.jpeg",
//                        "uri": "http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8",
//                        "mediaType": "image/jpeg",
//                        "height": 300,
//                        "width": 300,
//                        "timeAdded": "2018-08-18T04:33:24"
//                      }
//                    ],
//                    "contacts": [
//                      {
//                        "id": 8,
//                        "type": "phone",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 1,
//                        "notificationOrder": 0
//                      },
//                      {
//                        "id": 9,
//                        "type": "txt",
//                        "value": "(860) 841-2322",
//                        "contactOrder": 2,
//                        "notificationOrder": 1
//                      },
//                      {
//                        "id": 10,
//                        "type": "slack",
//                        "value": "POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX",
//                        "contactOrder": 3,
//                        "notificationOrder": 2
//                      }
//                    ]
//                  }
//                ],
//                "start": "2019-01-18",
//                "duration": 4,
//                "organization": {
//                  "id": 1,
//                  "name": "Arisia"
//                },
//                "level": "TURTLE"
//              }
//            ]
//        '''
            )
        headers {
            contentType(applicationJson())
        }
    }
}