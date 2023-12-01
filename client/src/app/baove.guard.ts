import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import * as moment from 'moment';
export const baoveGuard: CanActivateFn = (route:ActivatedRouteSnapshot, state:RouterStateSnapshot) => {
  const router: Router = inject(Router);
  const str = localStorage.getItem("expires_at") || "";

  if (str=="") return false; //chưa dn
  const expiresAt = JSON.parse(str);
  if(moment().isBefore(moment(expiresAt))==false)
  {
    return router.navigate(['dangnhap']);
  }
  return true;
};
