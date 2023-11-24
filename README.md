# CI-CD Project

- Mục tiêu : đây là dự án demo đơn giản về 1 luồng CI/CD, luồng CI/CD được xây dựng dựa trên tư tưởng của devops + gitops. Tự động hoá quy trình với các tools về CI/CD (devops) , quản lí tập trung trạng thái của resource và application với git (gitops). Luyện tập làm việc với các tools container , container orchestration.

- Dưới đây là hình ảnh tổng quan về luồng CI/CD.


<img width="1081" alt="Ảnh màn hình 2023-11-24 lúc 15 24 26" src="https://github.com/locnb1995/CI-CD/assets/28696846/f678d859-fa3e-45d6-bdbc-8b686fd873f8">


- Tech Stack:
  + Hạ tầng triển khai : Aws EC2 sử dụng ubuntu server , Aws VPC. Trên môi trường on-prem thì thay thế EC2 bằng máy chủ vật lí hoặc máy ảo , network thì tuỳ thuộc vào network trên on-prem. Lưu ý : mỗi server cần tối thiểu 2 CPU và RAM >= 2GB (đây là yêu cầu của K8s dành cho server controlplane và node).
  + Môi trường triển khai ứng dụng : Các ứng dụng sẽ được triển khai trong các container.
  + Container runtime : CRIO.
  + Container orchestration : K8s được cài đặt bằng kubeadm, với mô hình là 1 controlplane + 2 node. Yêu cầu đối với phần này là sẽ có 1 load balancer được trỏ tới 2 node của k8s. Bên trong k8s thì sử dụng Ingress trỏ tới các Service ClusterIP của các applications.
  + Image Build : vẫn sử dụng Docker Engine để build image nhưng các container sẽ chạy trong CRIO.
  + Image Repository : có thể sử dụng Docker registry. Nếu là private registry thì có thể sử dụng private Docker registry , Harbor registry. Image repository cũng sẽ chạy trong các container trên K8s.
  + Git : có thể sử dụng github. Nếu là private git thì có thể cài gitlab , gitea. Tương tự như Image repository thì gitlab và gitea cũng sẽ chạy trong các container trên K8s. Trên git sẽ lưu trữ 2 repo. Repo 1 gồm : Jenkinfile , Dockerfile , source code. Repo 2 gồm : Helm folder.
  + Helm : Khai báo template của Resources trên K8s.
  + Jenkins : Trong demo này Jenkins sẽ thực hiện CI (Kéo code -> build code -> build image). Jenkins sẽ chạy pipeline được khái báo trong Jenkinfile lưu trữ trên git.
  + Argocd : Trong demo này Argocd sẽ thực hiện CD (Đồng bộ Desired state trên git và Live state trên K8s). Argocd cũng sẽ quản lí Helm chứ không cài đặt quản lí Helm trên server, sync strategy có thể tuỳ chỉnh.


- Mô tả về flow :
  + Khi user commit code lên git , Jenkin sẽ thực hiện pipeline được cấu hình trong Jenkinfile của Repo 1 trên git , các stage bao gồm : clone project -> build project -> build image. Image sẽ được define trong Dockerfile trên Repo 1.
  + Sau khi image được build sẽ thay đổi image version trong helm và argocde sẽ tự sync state là deploy trên k8s.
  + Trong flow này , người dùng sẽ chỉ cần commit các thay đổi của code và các thay đổi đó sẽ tự động được apply lên k8s một cách hoàn toàn tự động.
 
- Kiến thức cần nắm được trước khi thực hiện : Linux , Network , Container , K8s , Helm, Git , Jenkins , Argocd.



