import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description: "If any page of a membership list returns an empty result then retun a 404"
    request {
        method GET()
        urlPath("/memberships?page=2")
    }
    response {
        status 404
    }
}