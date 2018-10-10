package com.houserose.guardian.membership;

//@RestController
public class MembershipController {

//   @Value("${guardian.membership.default-page-size}")
//   private Integer defaultPageSize;
//
//   private MembershipService membershipService;
//
//   public MembershipController(MembershipService membershipService) {
//      this.membershipService = membershipService;
//   }
//
//   @GetMapping(value = "/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
//   public List<Membership> listAllMemberships(
//           @RequestParam(defaultValue = "1") Integer page,
//           @RequestParam(defaultValue = "30") Integer pageSize) {
//
//
//      Page<Membership> resultPage = membershipService.getAllMemberships(page, pageSize);
//      if (page > resultPage.getTotalPages()) {
//         throw new ResourceNotFoundException();
//      }
//
//      return resultPage.getContent();
//   }
}
